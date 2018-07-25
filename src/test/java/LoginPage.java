import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    String username = "//*[@id=\"login-form-username\"]"; // need to verify this ID
    String passwordInputID = "//*[@id=\"login-form-password\"]"; // need to verify this ID
    String loginButtonID = "//*[@id=\"login-form-submit\"]"; // need to verify this ID

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLogin(String username) {
        driver.findElement(By.id(this.username)).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id(passwordInputID)).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(By.id(loginButtonID)).click();
    }
}