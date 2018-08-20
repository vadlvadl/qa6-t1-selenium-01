package eagles_tests;

import com.codeborne.selenide.WebDriverRunner;
import helpers.AppConfiguration;
import Steps.LoginStep;
import helpers.Credentials;
import helpers.PropertyReader;
import org.openqa.selenium.Cookie;
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

//        Cookie ck = new Cookie("JSESSIONID","1600C1AE257ED614D4F018A3F367D996");
//        WebDriverRunner.getWebDriver().manage().addCookie(ck);

        appConfig = new AppConfiguration("src/test/resources/jira.properties");
        credentials = new Credentials("src/test/resources/credentials.properties");
    }

    @Test (priority = 3)
    public void AddCommentTest(){

        String comment = "Comment added by autotest";

        // Add some ID to comment text
        Random random = new Random();
        int salt = random.nextInt() + 1;
        comment = "[" + salt + "]" + comment;

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigate();

        if(!dashboardPage.isLoggedIn()){
            System.out.println("User not logged in");
            LoginStep.login(credentials.getUsername(),credentials.getPassword());
        }

        IssuePage issuePage = new IssuePage();
        issuePage.navigateTo(appConfig.get("jiraIssueURL"));
        issuePage.clickAddCommentButton();
        issuePage.clickTextareaTabButton();
        issuePage.enterTextToTextarea(comment);
        issuePage.clickSubmitCommentButton();

        issuePage.checkLastCommentText(comment);

    }

    @Test(enabled = false)
    public void changeIssuePriorityTest(){

        String requiredIssuePriority = "High";

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigate();

        if(!dashboardPage.isLoggedIn()){
            LoginStep.login(credentials.getUsername(),credentials.getPassword());
        }

        IssuePage issuePage = new IssuePage();
        issuePage.navigateTo(appConfig.get("jiraIssueURL"));
        issuePage.clickPriorityElement();
        issuePage.enterPriorityText(requiredIssuePriority);
        issuePage.clickSubmitCommentButton();

    }
}
