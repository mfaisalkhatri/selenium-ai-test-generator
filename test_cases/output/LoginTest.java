package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.example.test.LoginPage;
import com.example.test.MyAccountPage;

public class LoginTest {
    @Test
    public void testLogin() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = null;

        loginPage.navigateToLoginPage();
        loginPage.enterEmail("Johndoe881@email.com");
        loginPage.enterPassword("Password@321");
        loginPage.clickLoginButton();

        myAccountPage = new MyAccountPage(driver);

        if (myAccountPage.isMyAccountPageDisplayed()) {
            System.out.println("Login successful and 'My Account' page is displayed.");
        } else {
            System.out.println("Failed to login or 'My Account' page is not displayed.");
        }
    }
}