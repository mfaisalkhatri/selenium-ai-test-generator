package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for email input field
    private By emailField = By.id("input-email");
    // Locator for password input field
    private By passwordField = By.id("input-password");
    // Locator for login button
    private By loginButton = By.xpath("//input[@value='Login']");
    // Locator for my account heading (after successful login)
    private By myAccountHeading = By.xpath("//h2[normalize-space()='My Account']");

    /**
     * Enter email address in the email field
     * @param email User's email address
     */
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    /**
     * Enter password in the password field
     * @param password User's password
     */
    public void enterPassword(String password) {
        driver.findElement(password, passwordField).sendKeys(password);
    }

    /**
     * Click the login button
     */
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    /**
     * Verify that the My Account heading is displayed after login
     * @return boolean indicating if the heading is present
     */
    public boolean isMyAccountDisplayed() {
        return driver.findElement(myAccountHeading).isDisplayed();
    }
}