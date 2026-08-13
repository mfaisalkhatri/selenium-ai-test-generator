import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for form fields
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By address = By.id("address");
    private final By city = By.id("city");
    private final By state = By.id("state");
    private final By zipCode = By.id("zip-code");
    private final By phone = By.id("phone");
    private final By ssn = By.id("ssn");
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By confirmPassword = By.id("confirmPassword");
    private final By registerButton = By.id("registerButton");
    private final By welcomeHeading = By.id("welcomeHeading");
    private final By successMessage = By.id("successMessage");

    // Method to enter first name
    public void enterFirstName(String text) {
        driver.findElement(firstName).sendKeys(text);
    }

    // Method to enter last name
    public void enterLastName(String text) {
        driver.findElement(lastName).sendKeys(text);
    }

    // Method to enter address
    public void enterAddress(String text) {
        driver.findElement(address).sendKeys(text);
    }

    // Method to enter city
    public void enterCity(String text) {
        driver.findElement(city).sendKeys(text);
    }

    // Method to enter state
    public void enterState(String text) {
        driver.findElement(state).sendKeys(text);
    }

    // Method to enter zip code
    public void enterZipCode(String text) {
        driver.findElement(zipCode).sendKeys(text);
    }

    // Method to enter phone number
    public void enterPhone(String text) {
        driver.findElement(phone).sendKeys(text);
    }

    // Method to enter SSN
    public void enterSSN(String text) {
        driver.findElement(ssn).sendKeys(text);
    }

    // Method to enter username
    public void enterUsername(String text) {
        driver.findElement(username).sendKeys(text);
    }

    // Method to enter password
    public void enterPassword(String text) {
        driver.findElement(password).sendKeys(text);
    }

    // Method to enter confirm password
    public void enterConfirmPassword(String text) {
        driver.findElement(confirmPassword).sendKeys(text);
    }

    // Method to click register button
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    // Method to get welcome heading text
    public String getWelcomeHeadingText() {
        return driver.findElement(welcomeHeading).getText();
    }

    // Method to get success message text
    public String getSuccessMessageText() {
        return driver.findElement(successMessage).getText();
    }
}