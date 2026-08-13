package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchText(String searchText) {
        // Using id locator for search text box
        WebElement searchTextBox = driver.findElement(By.id("search"));
        searchTextBox.sendKeys(searchText);
    }

    public void clickSearchButton() {
        // Using css selector for search button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}