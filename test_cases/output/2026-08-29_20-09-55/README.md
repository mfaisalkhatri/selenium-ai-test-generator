# Ecommerce Product Search Test

## How to Run the Test

1. Ensure ChromeDriver is in your system's PATH or update the `webdriver.chrome.driver` system property with the correct path to your chromedriver executable
2. Install required dependencies using Maven:
```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.23.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.4.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```
3. Execute the test using TestNG:
```bash
mvn test
```