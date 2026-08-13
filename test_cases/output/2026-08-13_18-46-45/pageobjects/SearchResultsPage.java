package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductDisplayed(String productName) {
        // Using partial link text locator for product link
        try {
            WebElement productLink = driver.findElement(By.partialLinkText(productName));
            return productLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}