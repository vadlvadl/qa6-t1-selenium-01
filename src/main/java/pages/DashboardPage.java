package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;
    private String createNewIssueButtonXpath = "//*[@id=\"create_link\"]";

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }


    public  void clickCreateIssueButton() {
        driver.findElement(By.xpath(createNewIssueButtonXpath)).click();
    }

}
