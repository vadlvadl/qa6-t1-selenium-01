package eagles_tests;

import Steps.BeforeTestSteps;
import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.SearchPage;


import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class JiraFindIssueTest {

    public  static DashboardPage dashboardPage;
    public  static SearchPage searchPage;
    public  static BeforeTestSteps beforeTestSteps;

    @BeforeTest
    public void setupBeforeTest () {
        beforeTestSteps =new BeforeTestSteps();
        dashboardPage = new DashboardPage();
        searchPage=new SearchPage();
        beforeTestSteps.setupAndLogin();
    }
    @Test (priority = 4)
    public  void findCreatedIssueTest (){
        String summary ="[Test Automation] QAAUTO6-T1_test02";
        String issueType ="Task";
        String summaryOfSearchedTask ="Test Automation QAAUTO6-T1_test02";
        String jqlRequestForSearching = "project = QAAUT6 AND assignee = currentUser() AND  summary ~ \"\\\\["+summaryOfSearchedTask+"\\\\]\"AND type ="+issueType+" ORDER BY createdDate DESC";


        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchForIssuesButton();
        searchPage.clickAdvancedButton();
        searchPage.fillJQLField(jqlRequestForSearching);
        searchPage.clickSearchButton();

        $(byXpath("//tbody[@class=\"ui-sortable\"]/tr[1]")).should(Condition.visible);//проверяет, что иcкомый issue есть в списке
        // или можно через
        //Assert.assertTrue($(byXpath("//li[@title =\""+summary+"\"]")).isDisplayed(),"This task not exist!");

    }
}
