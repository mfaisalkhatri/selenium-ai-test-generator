package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for search box
    private By searchBoxLocator = By.id("search");
    
    // Locator for search button
    private By searchButtonLocator = By.xpath("//button[@type='submit']");

    /**
     * Enter search text in the search box
     * @param searchText Text to search for
     */
    public void enterSearchText(String searchText) {
        driver.findElement(searchBoxLocator).sendKeys(searchText);
    }

    /**
     * Click the search button
     */
    public void clickSearchButton() {
        driver.findElement(searchButtonLocator).click();
    }
}