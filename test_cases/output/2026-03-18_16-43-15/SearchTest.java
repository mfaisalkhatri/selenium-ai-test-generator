package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Instantiate the Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void searchForProduct() {
        HomePage homePage = new HomePage(driver);
        String productName = "iPhone";
        homePage.searchForProduct(productName);

        // Add an assert statement to verify that the product is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='iPhones']")).isDisplayed());
    }
}