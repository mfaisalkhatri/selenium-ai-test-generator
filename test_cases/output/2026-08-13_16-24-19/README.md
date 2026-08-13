# ECommerce Login Test Automation

## Prerequisites
1. Java Development Kit (JDK) 17+
2. Maven for dependency management
3. ChromeDriver compatible with your Chrome browser version
4. TestNG framework
5. Selenium WebDriver Java bindings

## Setup Instructions
1. Clone the repository
2. Update the `System.setProperty` path in LoginTest.java with your ChromeDriver path
3. Ensure the following dependencies are in your `pom.xml`:
```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.13.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.4.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Running Tests
1. Open terminal in project root directory
2. Execute the following command:
```bash
mvn test
```
3. Alternatively, run testng.xml file using TestNG IDE plugin

## Test Execution
- The test will:
  1. Open Chrome browser
  2. Navigate to login page
  3. Enter credentials
  4. Attempt login
  5. Verify "My Account" page is displayed
  6. Close browser and quit WebDriver