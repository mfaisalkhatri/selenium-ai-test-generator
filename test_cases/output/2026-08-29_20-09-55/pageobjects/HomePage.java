package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String product) {
        // Locate search box by name attribute (more specific than generic selectors)
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys(product);
        
        // Locate search button by id attribute (more specific than generic selectors)
        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();
    }

    public boolean isProductDisplayed(String productName) {
        // Locate product element by exact text content (more reliable than CSS/XPATH)
        try {
            WebElement productElement = driver.findElement(By.xpath("//h2[text()='" + productName + "']"));
            return productElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}