package Steps;

import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;


public class LoginStep {

    private String username;
    private String password;
    private String url;

    public LoginStep(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void login(){
        open(url);

        LoginPage loginPage = new LoginPage();
        loginPage.atLoginPage();
        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();
    }
}
