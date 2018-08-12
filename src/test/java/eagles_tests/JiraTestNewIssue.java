package eagles_tests;

import com.codeborne.selenide.Configuration;

import helpers.PropertyReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.IssueDialogPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class JiraTestNewIssue {

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

    @Test(enabled = true)
    public void createNewTaskTest(){

        String newIssueSummary = "[Test Automation] QAAUTO6-T1_test02";
        String newIssueDescription = "Testing issue created according to http://jira.hillel.it:8080/browse/QAAUT6-1 task";

        String loginURL = appConfig.getStringValue("jiraURL");

        // Run browser and get needed address
        open(loginURL);

        LoginPage loginPage = new LoginPage();
        loginPage.atLoginPage();
        loginPage.enterLogin(credentials.getStringValue("jiraLogin",appConfig.getStringValue("jiraLogin")));
        loginPage.enterPassword(credentials.getStringValue("jiraPassword",appConfig.getStringValue("jiraPassword")));
        loginPage.clickSubmit();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isLoggedIn();
        dashboardPage.clickCreateIssueButton();

        IssueDialogPage issueDialogPage = new IssueDialogPage();

        issueDialogPage.enterSummary(newIssueSummary);
        issueDialogPage.enterDescription(newIssueDescription);
        issueDialogPage.clickAssignToMe();
        issueDialogPage.clickCreateButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
