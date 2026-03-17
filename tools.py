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
- Generate Page Object files
- Generate Test class
- Generate testng.xml
- Add comments explaining each step

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