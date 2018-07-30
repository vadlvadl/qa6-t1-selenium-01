package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CreateIssue {
    private String createNewIssueButtonXpath = "//*[@id=\"create_link\"]";
    private String inputProjectXpath = "//*[@id=\"project-field\"]";
    private String inputIssueTypeXpath = "//*[@id=\"issuetype-field\"]";

     public  void clickNewIssueButton() {
        $(By.xpath(createNewIssueButtonXpath)).click();
    }

    public  void enterProjectName(String projectName){
        $(By.xpath(inputProjectXpath)).sendKeys(projectName);
        $(By.xpath(inputProjectXpath)).submit();
    }
    public  void enterIssueType(String issueType){
        $(By.xpath(inputIssueTypeXpath)).sendKeys(issueType);
        $(By.xpath(inputIssueTypeXpath)).submit();
    }
}
