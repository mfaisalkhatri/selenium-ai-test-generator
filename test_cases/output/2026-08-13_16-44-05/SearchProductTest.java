package com.tests;

import com.pages.HomePage;
import com.pages.ProductSearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchProductTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductSearchResultPage productSearchResultPage;

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver (Assuming ChromeDriver is in system PATH)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ecommerce-playground.lambdatest.io/index.php");
        homePage = new HomePage(driver);
        productSearchResultPage = new ProductSearchResult
    }

    @Test
    public void testSearchProduct() {
        // Step 3: Enter "iPhone" in the Search text box
        homePage.enterSearchText("iPhone");
        
        // Step 4: Click on the Search Button
        homePage.clickSearchButton();
        
        // Step 5: Add assert statement to verify product is displayed
        Assert.assertTrue(productSearchResultPage.isProductDisplayed(), "iPhone product not displayed after search");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}