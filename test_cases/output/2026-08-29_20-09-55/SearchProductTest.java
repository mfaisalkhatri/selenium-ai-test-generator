package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchProductTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        // Initialize ChromeDriver without using WebDriverManager
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    public void testSearchProduct() {
        // Navigate to the application URL
        driver.get("https://ecommerce-playground.lambdatest.io/index.php");

        // Perform search operation
        homePage.searchProduct("iPhone");

        // Verify product is displayed
        boolean isProductDisplayed = homePage.isProductDisplayed("iPhone");
        Assert.assertTrue(isProductDisplayed, "Product 'iPhone' not displayed after search");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}