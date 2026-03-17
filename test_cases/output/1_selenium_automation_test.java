Here are the Selenium WebDriver Java test scripts using Page Object Model, TestNG framework, and best coding practices:

**Page Object Files:**
```java
// EmailLogin.java
public class EmailLogin {
    private final WebDriver driver;

    public EmailLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("input-password")).sendKeys(password);
    }
}

// MyAccountPage.java
public class MyAccountPage {
    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMyAccountPageDisplayed() {
        return driver.getTitle().equals("My Account");
    }
}
```

**Test Class:**
```java
// LoginTest.java
public class LoginTest extends Assert {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginScenario() {
        EmailLogin emailLogin = new EmailLogin(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        // Step 1: Open Chrome browser and navigate to the application URL
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        // Step 2-4: Enter email and password
        emailLogin.enterEmail("Johndoe881@email.com");
        emailLogin.enterPassword("Password@321");

        // Step 5: Assert that "My Account" page is displayed
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
    }
}
```

**testng.xml:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Application Login Scenario" verbose="2">
    <test name="LoginTest">
        <classes>
            <class name="com.example.LoginTest"/>
        </classes>
    </test>
</suite>
```

**Notes:**

* The Page Object files (EmailLogin and MyAccountPage) encapsulate the logic for interacting with specific page elements.
* The Test class (LoginTest) sets up and tears down a ChromeDriver instance, performs the login scenario steps, and asserts that the "My Account" page is displayed.
* The testng.xml file defines the test suite, which includes the LoginTest class.
* This script uses Selenium WebDriver with Java, Page Object Model, and TestNG framework to automate the application login scenario.

Remember to replace `com.example` with your actual package name.