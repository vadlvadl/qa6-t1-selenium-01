package eagles_tests;

import helpers.AppConfiguration;
import Steps.LoginStep;

import helpers.Credentials;
import helpers.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AuiFlagContainer;
import pages.DashboardPage;
import pages.IssueDialogPage;
import pages.IssuePage;

import static com.codeborne.selenide.Selenide.open;

public class JiraTestNewIssue {

    private AppConfiguration appConfig;
    private Credentials credentials;
    private String jiraTaskKey = "";
    private String jiraTaskURL = "";

    @BeforeTest
    public void setUp(){
        appConfig = new AppConfiguration("src/test/resources/jira.properties");
//        credentials = new Credentials("src/test/resources/credentials.properties");
    }

    @Test (priority = 1)
    public void createNewTaskTest(){

        String newIssueSummary = "[Test Automation] QAAUTO6-T1_test02";
        String newIssueDescription = "Testing issue created according to http://jira.hillel.it:8080/browse/QAAUT6-1 task";

        DashboardPage dashboardPage = new DashboardPage();
        open(appConfig.get("jiraDashboardURL"));

        if(!dashboardPage.isLoggedIn()){

            LoginStep.login(appConfig.get("jiraLogin"),appConfig.get("jiraPassword"));
            open(appConfig.get("jiraDashboardURL"));

        }

        dashboardPage.clickCreateIssueButton();

        IssueDialogPage issueDialogPage = new IssueDialogPage();

        issueDialogPage.enterSummary(newIssueSummary);
        issueDialogPage.clickVisualModeTabButton();
        issueDialogPage.enterDescription(newIssueDescription);
        issueDialogPage.clickAssignToMe();
        issueDialogPage.clickCreateButton();

        AuiFlagContainer dialog = new AuiFlagContainer();
        jiraTaskKey = dialog.getCreatedIssueKey();
        jiraTaskURL = dialog.getCreatedIssueLink();

        System.out.printf("Issue " + jiraTaskKey + " created\n");
        System.out.printf("Link: " + jiraTaskURL + "\n");

        Assert.assertEquals(true,dialog.isSuccessDialogDisplayed());
    }

    @Test (priority = 10)
    public void deleteTaskTest(){

        IssuePage issuePage = new IssuePage();
        issuePage.navigateTo(jiraTaskURL);
        issuePage.clickMenuMoreButton();
        issuePage.clickDeleteIssue();
        issuePage.confirmDeleteIssue();

        AuiFlagContainer dialog = new AuiFlagContainer();

        Assert.assertEquals(true, dialog.isSuccessDialogDisplayed());
    }
}
