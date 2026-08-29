import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize ChromeDriver (ensure chromedriver is in system PATH)
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Test
    public void registerUserTest() {
        // Step 3: Verify page heading
        Assert.assertEquals(driver.getTitle(), "Parabank - Register");

        // Step 4-14: Fill registration form
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterFirstName("John");
        registrationPage.enterLastName("Doe");
        registrationPage.enterAddress("Mccaleine, 189, street");
        registrationPage.enterCity("New York");
        registrationPage.enterState("Yorkshire");
        registrationPage.enterZipCode("370788");
        registrationPage.enterPhone("0789876778");
        registrationPage.enterSSN("6673625143");
        registrationPage.enterUsername("johndoe123");
        registrationPage.enterPassword("Password123$");
        registrationPage.enterConfirmPassword("Password123$");
        registrationPage.clickRegister();

        // Step 16: Verify welcome message
        Assert.assertEquals(registrationPage.getWelcomeMessage(), "Welcome johndoe123");

        // Step 17: Verify success message
        Assert.assertEquals(registrationPage.getSuccessMessage(), "Your account was created successfully. You are now logged in.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}