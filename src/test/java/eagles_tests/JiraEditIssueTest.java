package eagles_tests;

import Steps.InitStep;
import Steps.LoginStep;
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

        String comment = "Comment added by autotest";
        String issueURL = appConfig.getStringValue("jiraIssueURL");
        String dashboardURL = appConfig.getStringValue("jiraDashboardURL");

        // Add some ID to comment text
        Random random = new Random();
        int salt = random.nextInt() + 1;
        comment = "[" + salt + "]" + comment;

        DashboardPage dashboardPage = new DashboardPage();
        open(dashboardURL);

        if(!dashboardPage.isLoggedIn()){

            LoginStep.login(appConfig,credentials);
            open(dashboardURL);
        }

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
        String dashboardURL = appConfig.getStringValue("jiraDashboardURL");
        String issueURL = appConfig.getStringValue("jiraIssueURL");

        DashboardPage dashboardPage = new DashboardPage();
        open(dashboardURL);

        if(!dashboardPage.isLoggedIn()){

            LoginStep.login(appConfig,credentials);
            open(dashboardURL);
        }

        open(issueURL);

        IssuePage issuePage = new IssuePage();
        issuePage.clickPriorityElement();
        issuePage.enterPriorityText(requiredIssuePriority);
        issuePage.clickSubmitCommentButton();

    }
}
