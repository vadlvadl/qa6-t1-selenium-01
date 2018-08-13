package Steps;

import helpers.PropertyReader;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;


public class LoginStep {

    public static void login(PropertyReader appConfig, PropertyReader credentials){
        open(appConfig.getStringValue("jiraURL"));

        LoginPage loginPage = new LoginPage();
        loginPage.atLoginPage();
        loginPage.enterLogin(credentials.getStringValue("jiraLogin",appConfig.getStringValue("jiraLogin")));
        loginPage.enterPassword(credentials.getStringValue("jiraPassword",appConfig.getStringValue("jiraPassword")));
        loginPage.clickSubmit();
    }
}
