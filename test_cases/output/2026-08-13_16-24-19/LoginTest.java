package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    /**
     * Setup method to initialize WebDriver and navigate to login page
     */
    @BeforeMethod
    public void setUp() {
        // Set the system property for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Maximize browser window
        driver.manage().window().maximize();
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Navigate to login page
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
    }

    /**
     * Test method to verify login functionality
     */
    @Test
    public void testLogin() {
        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);
        // Enter email address
        loginPage.enterEmail("Johndoe881@email.com");
        // Enter password
        loginPage.enterPassword("Password@321");
        // Click login button
        loginPage.clickLogin();

        // Create AccountPage object
        AccountPage accountPage = new AccountPage(driver);
        // Verify My Account heading is displayed
        Assert.assertTrue(accountPage.isMyAccountDisplayed(), "My Account heading not displayed after login");
    }

    /**
     * Teardown method to close browser and quit WebDriver
     */
    @AfterMethod
    public void tearDown() {
        // Close current browser window
        driver.close();
        // Quit WebDriver
        driver.quit();
    }
}