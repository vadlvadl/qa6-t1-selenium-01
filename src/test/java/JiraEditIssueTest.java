import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import pages.IssueDialogPage;
import pages.IssuePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class JiraEditIssueTest {

    @Test
    public void AddCommentTest(){

        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.timeout = 7000;

        String comment = "Comment added by autotest";
        String loginURL = "https://jira.hillel.it:8080/";
        String issueURL = "https://jira.hillel.it:8080/browse/QAAUT6-56";

        open(loginURL);

        LoginPage loginPage = new LoginPage();

        loginPage.enterLogin("webinar5");
        loginPage.enterPassword("webinar5");
        loginPage.clickSubmit();

        open(issueURL);

        IssuePage issuePage = new IssuePage();
        issuePage.clickAddCommentButton();
        issuePage.clickTextareaTabButton();
        issuePage.enterTextToTextarea(comment);
        issuePage.clickSubmitCommentButton();

    }
}
