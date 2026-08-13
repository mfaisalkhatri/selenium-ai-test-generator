from dataclasses import dataclass, field
from pathlib import Path
from dotenv import load_dotenv
from dotenv import load_dotenv
from openai import OpenAI
import os


load_dotenv()

@dataclass
class OpenAIConfig:
    model_name: str = os.getenv("OPENAI_MODEL_NAME", "gpt-5")
    max_tokens: int = int(os.getenv("OPENAI_MAX_TOKENS", "4096"))
    temperature: float = float(os.getenv("OPENAI_TEMPERATURE", "0.3"))
    api_key: str = os.getenv("OPENAI_API_KEY", "")

    @property
    def client(self):
        if not self.api_key:
            raise ValueError(
                "OPENAI_API_KEY is required when using OpenAI provider"
            )

        return OpenAI(api_key=self.api_key)


@dataclass
class OllamaConfig:
    model: str = os.getenv("OLLAMA_MODEL_NAME", "llama3")
    prompt: str = "You are a Selenium WebDriver test automation expert. Generate Selenium WebDriver Java test scripts. STRICTLY follow the format. Any deviation is not acceptable."
    stream: bool = False
    temperature: float = float(os.getenv("OLLAMA_TEMPERATURE", "0.3"))
    ollama_endpoint: str = os.getenv("OLLAMA_ENDPOINT", "http://localhost:11434/api/generate")

@dataclass
class FileConfig:
    input_file: Path = Path("test_cases/input/sample_test_case.txt")
    output_file_path: Path = Path("test_cases/output/")

@dataclass
class AppConfig:
    provider:str = "ollama" #openai or ollama
    openai: OpenAIConfig = field(default_factory=OpenAIConfig)
    ollama: OllamaConfig = field(default_factory=OllamaConfig)
    files: FileConfig = field(default_factory=FileConfig)

config = AppConfig()