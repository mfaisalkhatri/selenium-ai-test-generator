# Parabank Registration Test Automation

## Requirements
- Java 17 installed
- Selenium WebDriver Java dependency
- TestNG dependency
- ChromeDriver (ensure it's in your system PATH)

## How to Run
1. Place all files in the same directory
2. Open terminal/command prompt
3. Run the test using TestNG:
   ```
   java -cp "path/to/testng.jar;path/to/selenium-java.jar;path/to/your/files" org.testng.TestNG testng.xml
   ```

## Notes
- This test assumes ChromeDriver is available in the system PATH
- All test steps are implemented using Page Object Model
- Assertions are performed using TestNG's built-in assertion methods