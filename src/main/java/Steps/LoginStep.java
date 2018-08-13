package Steps;

import pages.LoginPage;


public class LoginStep {

    public static void login(String username, String password){

        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.atLoginPage();
        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();

    }
}
