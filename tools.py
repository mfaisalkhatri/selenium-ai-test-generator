import os
import requests

from typing import Optional
from pathlib import Path
from dotenv import load_dotenv
from openai import OpenAI

from config import config

load_dotenv()

client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))

def load_test_case_from_file(file_path: str | Path) -> str:
    try:
        with open(file_path, "r", encoding="utf-8") as file:
            return file.read()
    except FileNotFoundError:
        raise FileNotFoundError(f"Test case file not found: {file_path}")
    except Exception as e:
        raise RuntimeError(f"Error reading test case file: {e}")

def build_prompt(use_case_text: str) -> str:
    return f"""
You are a test automation expert specializing in Selenium WebDriver with Java.

Generate Selenium automation test script using the following requirements:
- Use latest Selenium WebDriver with Java
- Follow Page Object Model (POM)
- Use latest version of TestNG framework
- Apply best coding practices
- Add comments explaining each step

IMPORTANT: You MUST follow the exact output format below.

Rules:
- ALWAYS start each file with ===FILE: filename===
- Use class names based on the use case (e.g., LoginPage.java, HomePage.java, etc.)
- Do NOT add explanations outside file blocks
- DO NOT skip this format
- If you do not follow this format, the output will be rejected

- Generate the following files:
OUTPUT FORMAT (STRICT):
===FILE: filename===
file content

  - Multiple Page Object classes(if needed)
  - Test class
  - testng.xml
  - README.md(Include use case text and steps to run the test)

Use Case:
{use_case_text}
"""

def generate_with_openai(prompt: str) -> Optional[str]:
    response = client.chat.completions.create(
        model=config.openai.model_name,
        temperature=config.openai.temperature,
        max_tokens=config.openai.max_tokens,
        messages=[
            {"role": "system", "content": "You generate Selenium WebDriver test automation automation scripts using Java."},
            {"role": "user", "content": prompt},
        ],
    )

    return response.choices[0].message.content

def generate_with_ollama(prompt: str) -> str:
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

    return data.get("response", "")


def generate_selenium_test_script(test_case_text: str) -> Optional[str]:
    prompt = build_prompt(test_case_text)

    provider = config.provider.lower()

    if provider == "openai":
        return generate_with_openai(prompt)

    elif provider == "ollama":
        return generate_with_ollama(prompt)

    else:
        raise ValueError(f"Unsupported provider: {provider}")

def split_and_save_files(generated_text: str, base_output_path: Path) -> None:

        sections = generated_text.split("===FILE:")
        if len(sections)<=1:
            raise ValueError ("No Structured files found in AI response!")
        
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

            with open(file_path, "w", encoding="utf-8") as f:
                f.write(content)

            print(f"✅ Created: {file_path}")
