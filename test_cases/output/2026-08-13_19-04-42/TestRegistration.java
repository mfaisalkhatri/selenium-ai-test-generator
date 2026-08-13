import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRegistration {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void testRegisterUser() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Verify initial heading
        String heading = registrationPage.getWelcomeHeadingText();
        Assert.assertEquals(heading, "Signing up is easy!");

        // Fill out registration form
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

        // Submit form
        registrationPage.clickRegister();

        // Verify welcome message
        String welcomeText = registrationPage.getWelcomeHeadingText();
        Assert.assertEquals(welcomeText, "Welcome johndoe123");

        // Verify success message
        String successText = registrationPage.getSuccessMessageText();
        Assert.assertEquals(successText, "Your account was created successfully. You are now logged in.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}