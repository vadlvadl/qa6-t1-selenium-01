package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * The {@code AuiFlagContainer} represents a dialog
 * which is shown when task is created, deleted, etc.
 *
 */
public class AuiFlagContainer {

    private String mainContainerID = "aui-flag-container";
    private String createdKeyLinkXPath = "//a[@class = 'issue-created-key issue-link']";

    public String getCreatedIssueKey(){
        return $(byXpath(createdKeyLinkXPath)).getAttribute("data-issue-key");
    }

    public String getCreatedIssueLink(){
        return $(byXpath(createdKeyLinkXPath)).getAttribute("href");
    }

    public boolean isSuccessDialogDisplayed(){
        return $(byXpath("//*[@id='" + mainContainerID + "']//div[contains(@class,'success')]")).shouldBe(Condition.visible).isDisplayed();
    }
}
