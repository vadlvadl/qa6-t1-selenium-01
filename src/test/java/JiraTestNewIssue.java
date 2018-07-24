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

        // login

        // click Create Issue button

        // fill the entries and press Create

        driver.close();
    }
}
