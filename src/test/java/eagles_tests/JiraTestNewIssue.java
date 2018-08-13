package eagles_tests;

import helpers.AppConfiguration;
import Steps.LoginStep;

import helpers.PropertyReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.IssueDialogPage;

import static com.codeborne.selenide.Selenide.open;

public class JiraTestNewIssue {

    private PropertyReader appConfig;
    private PropertyReader credentials;

    @BeforeTest
    public void initConfiguration(){
        AppConfiguration.initConfiguration();
        appConfig = AppConfiguration.getAppConfig();
        credentials = AppConfiguration.getCredentials();
    }

    @Test (priority = 1, enabled = false)
    public void createNewTaskTest(){

        String newIssueSummary = "[Test Automation] QAAUTO6-T1_test02";
        String newIssueDescription = "Testing issue created according to http://jira.hillel.it:8080/browse/QAAUT6-1 task";

        DashboardPage dashboardPage = new DashboardPage();
        open(appConfig.getStringValue("jiraDashboardURL"));

        if(!dashboardPage.isLoggedIn()){

            LoginStep.login(appConfig,credentials);
            open(appConfig.getStringValue("jiraDashboardURL"));

        }

        dashboardPage.clickCreateIssueButton();

        IssueDialogPage issueDialogPage = new IssueDialogPage();

        issueDialogPage.enterSummary(newIssueSummary);
        issueDialogPage.clickVisualModeTabButton();
        issueDialogPage.enterDescription(newIssueDescription);
        issueDialogPage.clickAssignToMe();
        issueDialogPage.clickCreateButton();

    }
}
