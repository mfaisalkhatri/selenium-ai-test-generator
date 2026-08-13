# Ecommerce Product Search Test

## Requirements
- Java 17 installed
- Maven for dependency management
- Chrome browser installed
- ChromeDriver compatible with Chrome version

## How to Run
1. Clone the repository
2. Navigate to project directory
3. Run the following command:
   ```bash
   mvn test
   ```
4. The test will execute using testng.xml configuration file

## Notes
- The test verifies that searching for "iPhone" displays the product in search results
- All locators use stable strategies (id, css selector, partial link text)
- TestNG framework is used for test execution and reporting