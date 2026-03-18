import re

from tools import load_test_case_from_file, generate_selenium_test_script,split_and_save_files
from config import config
from pathlib import Path


def main() -> None:
    try:
        input_file = config.files.input_file
        output_file_path = config.files.output_file_path

        use_case_text = load_test_case_from_file(input_file)

        if not use_case_text:
            raise ValueError("Test case file is empty.")

        generated_output = generate_selenium_test_script(use_case_text)
        print("\n🔍 RAW AI OUTPUT:\n")
        print(generated_output)

        if not generated_output:
            raise RuntimeError("Failed to generate Selenium WebDriver Java test automation scripts.")

        split_and_save_files(generated_output,output_file_path)

        print(f"✅ Selenium WebDriver Java test automation scripts generated successfully at: {output_file_path}")

    except Exception as e:
        print(f"❌ Error occurred: {e}")

if __name__ == "__main__":
    main()