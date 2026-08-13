package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.SearchResultsPage;

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
        // Navigate to homepage
        driver.get("https://ecommerce-playground.lambdatest.io/index.php");

        // Create page objects
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        // Perform search
        homePage.enterSearchText("iPhone");
        homePage.clickSearchButton();

        // Verify product is displayed
        Assert.assertTrue(searchResultsPage.isProductDisplayed("iPhone"), "iPhone product not displayed in search results");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}