package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private String createNewIssueButtonXpath = "//*[@id=\"create_link\"]";
    private String headerAccountDetail = "header-details-user-fullname";

    public void clickCreateIssueButton() {
        $(byXpath(createNewIssueButtonXpath)).click();
    }

    public void clickIssueButton() {
        $(byXpath("//*[@id=\"find_link\"] ")).click();
    }

    public  void clickSearchForIssuesButton () {
        $(byId("issues_new_search_link")).click();
    }

    public void isLoggedIn(){
        $(byId(headerAccountDetail)).waitUntil(Condition.visible,10000);
    }


}
