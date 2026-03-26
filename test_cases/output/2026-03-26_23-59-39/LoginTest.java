import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path_to_chrome_driver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testLoginScenario() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.enterEmail("Johndoe881@email.com");
        loginPage.enterPassword("Password@321");
        loginPage.clickLoginButton();

        WebElement myAccountPageTitle = driver.findElement(By.xpath("//h1[@class='page-title']"));
        Assert.assertTrue(myAccountPageTitle.isDisplayed(), "My Account page is not displayed");
    }
}