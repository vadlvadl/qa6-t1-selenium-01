import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    String username = "login-form-username";
    String passwordInputID = "login-form-password";
//    String loginButtonID = "login-form-submit";  // Entry point "http://jira.hillel.it:8080/login.jsp"
    String loginButtonID = "login"; // Entry point "http://jira.hillel.it:8080/secure/Dashboard.jspa"

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