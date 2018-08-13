package eagles_tests;

import helpers.AppConfiguration;
import Steps.LoginStep;
import helpers.Credentials;
import helpers.PropertyReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.IssuePage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;


public class JiraEditIssueTest {

    private AppConfiguration appConfig;
    private Credentials credentials;

    @BeforeTest
    public void setUp(){
        appConfig = new AppConfiguration("src/test/resources/jira.properties");
        credentials = new Credentials("src/test/resources/credentials.properties");
    }

    @Test (priority = 3)
    public void AddCommentTest(){

        String comment = "Comment added by autotest";
        String issueURL = appConfig.get("jiraIssueURL");
        String dashboardURL = appConfig.get("jiraDashboardURL");

        // Add some ID to comment text
        Random random = new Random();
        int salt = random.nextInt() + 1;
        comment = "[" + salt + "]" + comment;

        DashboardPage dashboardPage = new DashboardPage();
        open(dashboardURL);

        if(!dashboardPage.isLoggedIn()){

            LoginStep.login(credentials.getUsername(),credentials.getPassword());
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
        String dashboardURL = appConfig.get("jiraDashboardURL");
        String issueURL = appConfig.get("jiraIssueURL");

        DashboardPage dashboardPage = new DashboardPage();
        open(dashboardURL);

        if(!dashboardPage.isLoggedIn()){

            LoginStep.login(credentials.getUsername(),credentials.getPassword());
            open(dashboardURL);
        }

        open(issueURL);

        IssuePage issuePage = new IssuePage();
        issuePage.clickPriorityElement();
        issuePage.enterPriorityText(requiredIssuePriority);
        issuePage.clickSubmitCommentButton();

    }
}
