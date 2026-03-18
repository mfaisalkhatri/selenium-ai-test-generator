package com.example.test;

public class HomePage {

    private WebDriver driver;
    private String baseUrl;
    private LoginPage loginPage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        baseUrl = "https://ecommerce-playground.lambdatest.io/index.php";
    }

    public void searchForProduct(String productName) {
        driver.get(baseUrl);
        // Enter the product name in the search box
        driver.findElement(By.name("search")).sendKeys(productName);
        // Click on the Search Button
        driver.findElement(By.name("submit")).click();
    }
}