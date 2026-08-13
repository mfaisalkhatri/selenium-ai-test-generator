package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for my account heading
    private By myAccountHeading = By.xpath("//h2[normalize-space()='My Account']");

    /**
     * Verify that the My Account heading is displayed
     * @return boolean indicating if the heading is present
     */
    public boolean isMyAccountDisplayed() {
        return driver.findElement(myAccountHeading).isDisplayed();
    }
}