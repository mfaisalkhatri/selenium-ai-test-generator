package com.tests;

import com.tests.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchProductTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize ChromeDriver without setting system property
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchProduct() {
        // Navigate to the home page
        driver.get("https://ecommerce-playground.lambdatest.io/index.php");

        // Create page object instance
        HomePage homePage = new HomePage(driver);

        // Perform search actions
        homePage.enterSearchText("iPhone");
        homePage.clickSearchButton();

        // Verify product is displayed
        Assert.assertTrue(homePage.isProductDisplayed("iPhone"), "iPhone product not displayed after search");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}