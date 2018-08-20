package Steps;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginStep {

    public static void login(String username, String password){

        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.atLoginPage();
        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();

        String sessionID = WebDriverRunner.getWebDriver().manage().getCookieNamed("JSESSIONID").getValue();

        Cookie ck = new Cookie("JSESSIONID",sessionID);
        WebDriverRunner.getWebDriver().manage().addCookie(ck);
    }
}
