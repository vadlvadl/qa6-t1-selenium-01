import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class JiraTestNewIssue {

    protected WebDriver driver;

    @Test
    public void createNewTaskTest(){
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Run browser and get needed address
        driver.get("http://jira.hillel.it:8080/");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterLogin("webinar5");
        loginPage.enterPassword("webinar5");
        loginPage.clickSubmit();


        DashboardPage dashboardPage = new DashboardPage(driver);
        // Add methods to wait until page is loaded
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dashboardPage.clickCreateIssueButton();

        IssuePage issuePage = new IssuePage(driver);


        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        issuePage.enterSummary("[Test Automation] QAAUTO6-T1_test01");
        issuePage.enterDescription("Testing issue created according to http://jira.hillel.it:8080/browse/QAAUT6-1 task");
        issuePage.clickAssignToMe();
        issuePage.clickCreateButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.close();
    }
}
