# ECommerce Product Search Test

## Prerequisites
1. Java 17 installed
2. Maven installed
3. ChromeDriver (ensure it's in your system PATH)
4. TestNG dependency added to project

## Setup Instructions
1. Clone the repository
2. Open terminal in project root directory
3. Run: `mvn clean install`

## Running Tests
1. Navigate to project root directory
2. Run: `mvn test`
3. Test results will be available in `target/surefire-reports/`

## Notes
- All tests are organized using Page Object Model (POM)
- WebDriver is initialized in the test class using TestNG's @BeforeMethod
- Test results will include detailed failure information if any assertions fail
- The test searches for "iPhone" and verifies it appears in search results