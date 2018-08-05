import com.codeborne.selenide.Configuration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.IssueDialogPage;
import pages.IssuePage;
import pages.LoginPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class JiraEditIssueTest {

    @Test
    public void AddCommentTest(){

        String rootPath = System.getProperty("user.dir");

        PropertyReader appConfig = new PropertyReader(rootPath + "/jira.properties");
        PropertyReader credentials = new PropertyReader(rootPath + "/credentials.properties");

        Configuration.remote = appConfig.getStringValue("configurationRemote");
        Configuration.browser = appConfig.getStringValue("configurationBrowser");
        Configuration.timeout = appConfig.getIntValue("configurationTimeout");

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

    @Test
    public void changeIssuePriorityTest(){

        String rootPath = System.getProperty("user.dir");

        PropertyReader appConfig = new PropertyReader(rootPath + "/jira.properties");
        PropertyReader credentials = new PropertyReader(rootPath + "/credentials.properties");

        Configuration.remote = appConfig.getStringValue("configurationRemote");
        Configuration.browser = appConfig.getStringValue("configurationBrowser");
        Configuration.timeout = appConfig.getIntValue("configurationTimeout");

        String requiredIssuePriority = "critical";
    }
}
