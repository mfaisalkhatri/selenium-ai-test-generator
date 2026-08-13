package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductSearchResultPage {
    private WebDriver driver;

    public ProductSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for product name
    private By productNameLocator = By.xpath("//h2[contains(text(), 'iPhone')]");

    /**
     * Verify that the product "iPhone" is displayed
     * @return true if product is displayed, false otherwise
     */
    public boolean isProductDisplayed() {
        return driver.findElement(productNameLocator).isDisplayed();
    }
}