package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    String usernameInputID = "login-form-username";
    String passwordInputID = "login-form-password";
//    String loginButtonID = "login-form-submit";  // Entry point "http://jira.hillel.it:8080/login.jsp"
    String loginButtonID = "login"; // Entry point "http://jira.hillel.it:8080/secure/Dashboard.jspa"

    public void enterLogin(String username) {
        $(By.id(usernameInputID)).clear();
        $(By.id(usernameInputID)).sendKeys(username);
    }

    public void enterPassword(String password) {
        $(By.id(passwordInputID)).clear();
        $(By.id(passwordInputID)).sendKeys(password);
    }

    public void clickSubmit() {
        $(By.id(loginButtonID)).click();
    }

    public void atLoginPage(){
        $(byId(usernameInputID)).waitUntil(Condition.visible,6000);
    }
}