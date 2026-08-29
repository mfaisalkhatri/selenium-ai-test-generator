# ECommerce Product Search Test

## Requirements
- Java 17 installed
- TestNG library
- ChromeDriver executable in system PATH
- Maven or build tool for dependencies

## How to Run
1. Ensure ChromeDriver is available in system PATH
2. Run the test using TestNG:
   ```
   mvn test -Dtest=SearchProductTest
   ```
   or execute testng.xml directly from IDE

## Notes
- All test steps are implemented using Page Object Model
- TestNG assertions are used for validation
- WebDriver is properly initialized and closed in each test run