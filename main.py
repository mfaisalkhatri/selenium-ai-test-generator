import re

from tools import load_test_case_from_file, generate_selenium_test_script,split_and_save_files,create_timestamped_output_dir, check_llm_connection
from config import config
from pathlib import Path
from logger import logger

def main() -> None:
    try:
        logger.info("Starting Selenium AI Test Generator")

        if not check_llm_connection():
            logger.error(
                "❌ LLM connection check failed. "
                "Stopping test generation."
            )
            return
        
        input_file = config.files.input_file
        output_file_path = config.files.output_file_path
        run_output_dir = create_timestamped_output_dir(output_file_path)

        use_case_text = load_test_case_from_file(input_file)

        if not use_case_text:
            logger.error("Test case file is empty.")
            raise ValueError("Test case file is empty.")

        generated_output = generate_selenium_test_script(use_case_text)
        
        if not generated_output:
            logger.error("Failed to generate Selenium WebDriver Java test automation scripts.")
            raise RuntimeError("Failed to generate Selenium WebDriver Java test automation scripts.")

        split_and_save_files(generated_output,run_output_dir)
        logger.info(f"✅ All generated files saved successfully to {run_output_dir}")

    except Exception as e:
        logger.error(f"❌ Error occurred while generating output files: {e}")

if __name__ == "__main__":
    main()