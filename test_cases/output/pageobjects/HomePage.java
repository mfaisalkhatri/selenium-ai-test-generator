package com.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(name = "search_query")
    private WebElement searchTextBox;

    public void enterSearchQuery(String query) {
        searchTextBox.sendKeys(query);
    }

    public void clickSearchButton() {
        searchTextBox.submit();
    }
}