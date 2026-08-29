import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locate and interact with form fields
    public void enterFirstName(String firstName) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        driver.findElement(By.id("address")).sendKeys(address);
    }

    public void enterCity(String city) {
        driver.findElement(By.id("city")).sendKeys(city);
    }

    public void enterState(String state) {
        driver.findElement(By.id("state")).sendKeys(state);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(By.id("zip-code")).sendKeys(zipCode);
    }

    public void enterPhone(String phone) {
        driver.findElement(By.id("phone")).sendKeys(phone);
    }

    public void enterSSN(String ssn) {
        driver.findElement(By.id("ssn")).sendKeys(ssn);
    }

    public void enterUsername(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(By.id("confirm")).sendKeys(confirmPassword);
    }

    // Locate and click register button
    public void clickRegister() {
        driver.findElement(By.id("register-button")).click();
    }

    // Verify welcome message
    public String getWelcomeMessage() {
        return driver.findElement(By.id("welcome-message")).getText();
    }

    // Verify success message
    public String getSuccessMessage() {
        return driver.findElement(By.id("success-message")).getText();
    }
}