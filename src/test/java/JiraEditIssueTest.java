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

        PropertyReader pr1 = new PropertyReader(rootPath + "/jira.properties");
        PropertyReader credentials = new PropertyReader(rootPath + "/credentials.properties");

        Configuration.remote = pr1.getStringValue("configurationRemote");
        Configuration.browser = pr1.getStringValue("configurationBrowser");
        Configuration.timeout = pr1.getIntValue("configurationTimeout");

        Random random = new Random();
        int salt = random.nextInt() + 1;

        String comment = "Comment added by autotest";
        String loginURL = pr1.getStringValue("jiraURL");
        String issueURL = pr1.getStringValue("jiraIssueURL");

        // Add some ID to comment text
        comment = "[" + salt + "]" + comment;

        open(loginURL);

        LoginPage loginPage = new LoginPage();

        loginPage.enterLogin(credentials.getStringValue("jiraLogin"));
        loginPage.enterPassword(credentials.getStringValue("jiraPassword"));
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
}
