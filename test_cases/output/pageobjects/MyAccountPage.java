package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".page-heading")
    private WebElement myAccountHeading;

    public boolean isMyAccountPageDisplayed() {
        return myAccountHeading.isDisplayed();
    }
}