package eagles_tests;

import Steps.InitStep;
import com.codeborne.selenide.Configuration;
import helpers.PropertyReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.IssuePage;
import pages.LoginPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;


public class JiraEditIssueTest {

    private PropertyReader appConfig;
    private PropertyReader credentials;

    @BeforeTest
    public void initConfiguration(){
        InitStep.initConfiguration();
        appConfig = InitStep.getAppConfig();
        credentials = InitStep.getCredentials();
    }

    @Test
    public void AddCommentTest(){

        Random random = new Random();
        int salt = random.nextInt() + 1;

        String comment = "Comment added by autotest";
        String loginURL = appConfig.getStringValue("jiraURL");
        String issueURL = appConfig.getStringValue("jiraIssueURL");

        // Add some ID to comment text
        comment = "[" + salt + "]" + comment;

        open(loginURL);

        LoginPage loginPage = new LoginPage();

        loginPage.enterLogin(credentials.getStringValue("jiraLogin",appConfig.getStringValue("jiraLogin")));
        loginPage.enterPassword(credentials.getStringValue("jiraPassword",appConfig.getStringValue("jiraPassword")));
        loginPage.clickSubmit();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isLoggedIn();

        open(issueURL);

        IssuePage issuePage = new IssuePage();
        issuePage.clickAddCommentButton();
        issuePage.clickTextareaTabButton();
        issuePage.enterTextToTextarea(comment);
        issuePage.clickSubmitCommentButton();

        issuePage.checkLastCommentText(comment);

    }

    @Test(enabled = false)
    public void changeIssuePriorityTest(){

        String requiredIssuePriority = "High";
        String loginURL = appConfig.getStringValue("jiraURL");
        String issueURL = appConfig.getStringValue("jiraIssueURL");

        open(loginURL);

        LoginPage loginPage = new LoginPage();

        loginPage.enterLogin(credentials.getStringValue("jiraLogin",appConfig.getStringValue("jiraLogin")));
        loginPage.enterPassword(credentials.getStringValue("jiraPassword",appConfig.getStringValue("jiraPassword")));
        loginPage.clickSubmit();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isLoggedIn();

        open(issueURL);

        IssuePage issuePage = new IssuePage();
        issuePage.clickPriorityElement();
        issuePage.enterPriorityText(requiredIssuePriority);
        issuePage.clickSubmitCommentButton();

    }
}
