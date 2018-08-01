import com.codeborne.selenide.Configuration;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.IssueDialogPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class JiraTestNewIssue {

    @Test
    public void createNewTaskTest(){

        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.timeout = 7000;

        // Run browser and get needed address
        open("http://jira.hillel.it:8080/");

        LoginPage loginPage = new LoginPage();

        loginPage.enterLogin("webinar5");
        loginPage.enterPassword("webinar5");
        loginPage.clickSubmit();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.clickCreateIssueButton();

        IssueDialogPage issueDialogPage = new IssueDialogPage();

        issueDialogPage.enterSummary("[Test Automation] QAAUTO6-T1_test02");
        issueDialogPage.enterDescription("Testing issue created according to http://jira.hillel.it:8080/browse/QAAUT6-1 task");
        issueDialogPage.clickAssignToMe();
        issueDialogPage.clickCreateButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
