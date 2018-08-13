package eagles_tests;

import Steps.BeforeTestSteps;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.NewIssuePage;

public class JiraNewIssueTest {
    public  static NewIssuePage newIssuePage;
    public  static DashboardPage dashboardPage;
    public    static BeforeTestSteps beforeTestSteps;
    public  static  String summary ="[Test Automation] QAAUTO6-T1_test02";
    public  static  String issueType ="Task";


    @BeforeTest

    public void setupBeforeTest(){
        beforeTestSteps =new BeforeTestSteps();
        newIssuePage = new NewIssuePage();
        dashboardPage = new DashboardPage();
        beforeTestSteps.setupAndLogin();
    }



    @Test (priority = 2)

    public void CreateIssueTest () {

        dashboardPage.clickCreateIssueButton();

        newIssuePage.enterProjectName("QAAUTO-6 (QAAUT6)");
        newIssuePage.enterIssueType(issueType);
        newIssuePage.atRequiredPage(); //проверяет, что окно Create issue открыто.
        newIssuePage.enterSummary(summary);
        newIssuePage.enterDescription("Testing issue created according to http://jira.hillel.it:8080/browse/QAAUT6-1 task\"");
        newIssuePage.clickAssignToMe();
        newIssuePage.clickCreateButton();
        newIssuePage.isIssueCreated(); //проверяет, что окно Create issue правильно заполнено и закрыто.
    }
}
