package com.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa, selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchText(String text) {
        // Locate search box by id (more reliable than class names)
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys(text);
    }

    public void clickSearchButton() {
        // Locate search button by class name (specific to the page)
        driver.findElement(By.className("btn-search")).click();
    }

    public boolean isProductDisplayed(String productName) {
        // Locate product by combining text and class (more specific than generic selectors)
        return driver.findElement(By.xpath("//div[contains(text(), '" + productName + "') and contains(@class, 'product-name')]")).isDisplayed();
    }
}