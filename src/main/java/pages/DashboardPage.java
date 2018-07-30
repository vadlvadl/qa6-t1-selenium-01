package pages;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

       private String createNewIssueButtonXpath = "//*[@id=\"create_link\"]";

       public  void clickCreateIssueButton() {
        $(byXpath(createNewIssueButtonXpath)).click();
    }
       public  void clickIssueButton() {
        $(byXpath("//*[@id=\"find_link\"] ")).click();
    }
       public  void clickCurrentSearchButton() {
        $(byXpath("  //*[@id=\"jira.top.navigation.bar:issues_drop_current_lnk\"] ")).click();
    }


}
