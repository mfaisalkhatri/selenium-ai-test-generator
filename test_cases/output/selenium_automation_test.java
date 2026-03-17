Here are the Selenium WebDriver Java test scripts for the Application Login scenario using Page Object Model (POM) and TestNG framework:

**Page Object Files:**

Create a new package `com.lambdatest.pages` and add the following files:
```java
// Loginpage.java
package com.lambdatest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("#content > div.panel-body > form > button[type='submit']")).click();
    }
}
```

```java
// MyAccountPage.java
package com.lambdatest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMyAccountPageDisplayed() {
        return driver.findElement(By.linkText("My Account")).isDisplayed();
    }
}
```

**Test Class:**

Create a new package `com.lambdatest.tests` and add the following class:
```java
// LoginTest.java
package com.lambdatest.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.lambdatest.pages.LoginPage;
import com.lambdatest.pages.MyAccountPage;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize the Selenium WebDriver with Chrome browser
        driver = new ChromeDriver();
        // Navigate to the login page
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        // Enter email and password
        loginPage.enterEmail("Johndoe881@email.com");
        loginPage.enterPassword("Password@321");

        // Click the Login button
        loginPage.clickLoginButton();

        // Assert that the My Account page is displayed
        boolean isMyAccountPageDisplayed = myAccountPage.isMyAccountPageDisplayed();
        if (!isMyAccountPageDisplayed) {
            throw new AssertionError("Expected My Account page to be displayed, but it's not");
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
```

**testng.xml:**

Create a new file `testng.xml` in the same package as the test class:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Login Test Suite">
    <test name="Login Test">
        <classes>
            <class name="com.lambdatest.tests.LoginTest"/>
        </classes>
    </test>
</suite>
```

**Best Coding Practices:**

* Use meaningful variable names and method names.
* Follow the SOLID principles (Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, and Dependency Inversion Principle).
* Use try-catch blocks to handle exceptions and errors.
* Avoid using `Thread.sleep()` or `driver.manage().timeouts().implicitlyWait()` whenever possible. Instead, use explicit waits with `WebDriverWait` class.
* Keep the test classes and page object files separate and organized.

**Note:**

* Make sure you have the latest version of Selenium WebDriver (4.x) and TestNG framework (7.x) installed in your project.
* This is just an example script, and you may need to modify it based on your specific requirements and application under test.