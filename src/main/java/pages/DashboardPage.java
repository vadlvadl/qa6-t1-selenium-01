package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class DashboardPage {

    private String dashboardPageURL = "http://jira.hillel.it:8080/secure/Dashboard.jspa";
    private String createNewIssueButtonXpath = "//*[@id=\"create_link\"]";
    private String headerAccountDetail = "header-details-user-fullname";

    public void navigate(){
        open(dashboardPageURL);
    }

    public void clickCreateIssueButton() {
        $(byXpath(createNewIssueButtonXpath)).click();
    }

    public void clickIssueButton() {
        $(byXpath("//*[@id=\"find_link\"] ")).click();
    }

    public  void clickSearchForIssuesButton () {
        $(byId("issues_new_search_link")).click();
    }

    public void atRequiredPage(String url){
        url().equalsIgnoreCase(dashboardPageURL);
    }

    public boolean isLoggedIn(){
        return $(byId(headerAccountDetail)).exists();
    }
}
