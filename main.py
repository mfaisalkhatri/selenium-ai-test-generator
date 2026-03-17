from tools import load_test_case_from_file, generate_selenium_test_script
from config import config


def save_test_script(script: str, output_path) -> None:
    try:
        with open(output_path, "w", encoding="utf-8") as file:
            file.write(script)
    except Exception as e:
        raise RuntimeError(f"Failed to write test script: {e}")


def main() -> None:
    try:
        input_file = config.files.input_file
        output_file = config.files.output_file

        use_case_text = load_test_case_from_file(input_file)

        if not use_case_text:
            raise ValueError("Test case file is empty.")

        test_script = generate_selenium_test_script(use_case_text)

        if not test_script:
            raise RuntimeError("Failed to generate Selenium WebDriver Java test automation scripts.")

        save_test_script(test_script, output_file)

        print(f"✅ Selenium WebDriver Java test automation scripts generated successfully: {output_file}")

    except Exception as e:
        print(f"❌ Error occurred: {e}")


if __name__ == "__main__":
    main()