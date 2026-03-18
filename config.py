from dataclasses import dataclass, field
from pathlib import Path

@dataclass
class OpenAIConfig:
    model_name: str = "gpt-5"
    max_tokens: int = 1200
    temperature: float = 0.3


@dataclass
class OllamaConfig:
    model: str = "llama3"
    prompt: str = "You are a Selenium WebDriver test automation expert. Generate Selenium WebDriver Java test scripts. STRICTLY follow the format. Any deviation is not acceptable."
    stream: bool = False
    temperature: float = 0.3
    ollama_endpoint: str = "http://localhost:11434/api/generate"


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