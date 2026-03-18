package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php");
    }

    @Test
    public void searchForProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchQuery("iPhone");
        homePage.clickSearchButton();

        // Wait for the Search Result page to load and assert that the search results show the product "iPhone"
        WebElement searchResultPage = driver.findElement(By.xpath("//h2[contains(text(), 'iPhone')]"));
        Assert.assertTrue(searchResultPage.isDisplayed());
    }
}