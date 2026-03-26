public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
    }

    public void enterEmail(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}