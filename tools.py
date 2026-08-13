import requests

from config import config
from typing import Optional
from pathlib import Path
from datetime import datetime
from logger import logger

import requests

from config import config
from logger import logger


def check_llm_connection() -> bool:
    provider = config.provider.lower()

    logger.info(f"Checking {provider} connection...")

    if provider == "ollama":
        try:
            response = requests.get(
                config.ollama.ollama_baseurl + "/api/tags",
                timeout=5,
            )

            response.raise_for_status()

            logger.info("✅ Ollama connection successful.")
            return True

        except requests.exceptions.ConnectionError:
            logger.error(
                "❌ Unable to connect to Ollama. "
                "Make sure Ollama is running."
            )
            return False

        except requests.exceptions.Timeout:
            logger.error("❌ Ollama connection timed out.")
            return False

        except requests.exceptions.RequestException as e:
            logger.error(f"❌ Ollama health check failed: {e}")
            return False

    elif provider == "openai":
        try:
            config.openai.client.models.list()

            logger.info("✅ OpenAI connection successful.")
            return True

        except Exception as e:
            logger.error(f"❌ OpenAI connection failed: {e}")
            return False

    else:
        logger.error(f"❌ Unsupported provider: {provider}")
        return False

def load_test_case_from_file(file_path: str | Path) -> str:
    logger.info(f"Loading test case from: {file_path}")

    try:
        with open(file_path, "r", encoding="utf-8") as file:
            content = file.read()

        logger.info(f"Test case loaded successfully ({len(content)} characters)")
        return content

    except FileNotFoundError:
        logger.error(f"Test case file not found: {file_path}")
        raise FileNotFoundError(f"Test case file not found: {file_path}")
    except Exception as e:
        logger.exception(f"Error reading test case file: {e}")
        raise RuntimeError(f"Error reading test case file: {e}")

def build_prompt(use_case_text: str) -> str:
    logger.info("Building AI prompt")
    prompt = f"""
You are a test automation expert specializing in Selenium WebDriver with Java.

Generate Selenium automation test script using the following instructions and skills:
- Use Java 17 to write the code
- Use latest Selenium WebDriver Java dependency version to write code
- Do not write code statement "System.setProperty()" to add chromedriver path, in the tests
- Follow Page Object Model (POM)
- Use latest version of TestNG dependency
- Apply best coding practices for writing Java code
- Add comments explaining each step
- Add assertions using TestNG assertion
- Do not add random assertion statements in the code
- Do not mention any text in README that says that ChromeDriver path should be added to the Path
- Never use brittle XPATH and CSS Selectors selectors such as .btn-primary, .container > div:nth-child(2), #content div span, or auto-generated classes.

IMPORTANT: You MUST follow the exact output format below.

Rules:
- ALWAYS start each file with ===FILE: filename===
- Use class names based on the web page(e.g. HomPage.java, LoginPage.java, etc. These names are for instructions only, use class name specific to the web page)
- Do not add "Page" to the test class name
- Do NOT add explanations outside file blocks
- DO NOT skip this format
- If you do not follow this format, the output will be rejected
- DO NOT use markdown (no **, no ``` blocks)
- DO NOT add file names outside ===FILE: markers
- ONLY use ===FILE: filename=== format
- OUTPUT FORMAT FOR FILES(STRICT):
    ===FILE: filename===
    file content

- The following files MUST only be generated in the same order(STRICT). No deviation is acceptable:
  - Multiple Page Object classes(if needed) (Strictly Page object class, no WebDriver instantiation in these classes, Do not create duplicate page object classes)
  - Test class(WebDriver should be instantiated in the Test class, Do not use WebDriverManager to instantiate WebDriver, Use TestNG's @BeforeMethod annotation and define a method to instantiate the WebDriver, Use TestNG's @AfterMethod to quit the WebDriver)
  - Add assertions using TestNG assertion
  - Do not add random assertion statements in the code
  - testng.xml(Follow correct structure as per TestNG guidelines)
  - README.md (Include notes and steps to run the test using testng.xml file)
  
Use Case:
{use_case_text}
"""
    logger.info(f"Prompt created ({len(prompt)} characters)")
    return prompt


def generate_with_openai(prompt: str) -> Optional[str]:
    response = config.openai.client.chat.completions.create(
        model=config.openai.model_name,
        temperature=config.openai.temperature,
        max_tokens=config.openai.max_tokens,
        messages=[
            {"role": "system", "content": "You are a Selenium WebDriver test automation expert. Generate Selenium WebDriver Java test scripts. STRICTLY follow the format. Any deviation is not acceptable."},
            {"role": "user", "content": prompt},
        ],
    )

    return response.choices[0].message.content

def generate_with_ollama(prompt: str) -> str:
    logger.info(
        f"Generating test code with Ollama model: {config.ollama.model}"
    )

    response = requests.post(
        config.ollama.ollama_endpoint,
        json={
            "model": config.ollama.model,
            "prompt": config.ollama.prompt + "\n" + prompt,
            "stream": config.ollama.stream,
        },
    )

    response.raise_for_status()
    data = response.json()
    generated_text = data.get("response", "")

    logger.info(
        f"Ollama generation completed ({len(generated_text)} characters)"
    )

    return generated_text

def generate_selenium_test_script(test_case_text: str) -> Optional[str]:
    logger.info("Starting Selenium test generation")
    prompt = build_prompt(test_case_text)

    provider = config.provider.lower()
    logger.info(f"Using AI provider: {provider}")

    if provider == "openai":
        logger.info("Sending prompt to OpenAI")
        return generate_with_openai(prompt)

    elif provider == "ollama":
        logger.info("Sending prompt to Ollama")
        return generate_with_ollama(prompt)

    else:
        logger.error(f"Unsupported provider: {provider}")
        raise ValueError(f"Unsupported provider: {provider}")

def create_timestamped_output_dir(base_output_path: Path) -> Path:
    timestamp = datetime.now().strftime("%Y-%m-%d_%H-%M-%S")
    output_dir = base_output_path / timestamp
    output_dir.mkdir(parents=True, exist_ok=True)
    logger.info(f"Created output directory: {output_dir}")
    return output_dir


def split_and_save_files(generated_text: str, base_output_path: Path) -> None:

        sections = generated_text.split("===FILE:")
        if len(sections)<=1:
            logger.error("No structured files found in AI response")
            raise ValueError ("No Structured files found in AI response!")

        logger.info(f"Found {len(sections) - 1} generated files")
        pageobject_dir = base_output_path/"pageobjects"
        pageobject_dir.mkdir(parents=True, exist_ok=True)

        for section in sections[1:]:
            section = section.strip()
            parts = section.split("\n",1)
            raw_filename = parts[0].strip()
            
            filename =  raw_filename.replace("===", "").strip().split()[0]
            
            content = parts[1].strip() if len(parts)>1 else ""
            content = content.split("===FILE:")[0].strip()
            
            if filename.endswith("Page.java"):
                file_path = pageobject_dir / filename
            else:
                file_path = base_output_path / filename

            logger.info(f"Writing file: {file_path}")
            with open(file_path, "w", encoding="utf-8") as f:
                f.write(content)

            logger.info(f"Created: {file_path} ({len(content)} characters)")
            