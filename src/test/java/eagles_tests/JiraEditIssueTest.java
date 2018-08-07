package eagles_tests;

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

        // Get full path to root directory
        String rootPath = System.getProperty("user.dir");

        appConfig = new PropertyReader(rootPath + "/jira.properties");
        credentials = new PropertyReader(rootPath + "/credentials.properties");

        Configuration.remote = appConfig.getStringValue("configurationRemote");
        Configuration.browser = appConfig.getStringValue("configurationBrowser");
        Configuration.timeout = appConfig.getIntValue("configurationTimeout");
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

//    @Test
//    public void changeIssuePriorityTest(){
//
//        String rootPath = System.getProperty("user.dir");
//
//        PropertyReader appConfig = new PropertyReader(rootPath + "/jira.properties");
//        PropertyReader credentials = new PropertyReader(rootPath + "/credentials.properties");
//
//        Configuration.remote = appConfig.getStringValue("configurationRemote");
//        Configuration.browser = appConfig.getStringValue("configurationBrowser");
//        Configuration.timeout = appConfig.getIntValue("configurationTimeout");
//
//        String requiredIssuePriority = "critical";
//    }
}
