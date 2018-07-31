import com.codeborne.selenide.Configuration;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.IssuePage;
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

        IssuePage issuePage = new IssuePage();

        issuePage.enterSummary("[Test Automation] QAAUTO6-T1_test02");
        issuePage.enterDescription("Testing issue created according to http://jira.hillel.it:8080/browse/QAAUT6-1 task");
        issuePage.clickAssignToMe();
        issuePage.clickCreateButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
