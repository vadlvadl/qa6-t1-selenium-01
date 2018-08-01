package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class IssueDialogPage {

    private String inputSummaryXpath = "//*[@id=\"summary\"]";
    private String inputDescriptionID = "tinymce";
    private String assignToMeButtonXpath = "//*[@id=\"assign-to-me-trigger\"]";
    private String createButtonXpath = "//*[@id=\"create-issue-submit\"]";
    private String frameXpath = "//*/div[@class=\"mce-edit-area mce-container mce-panel mce-stack-layout-item mce-first\"]/iframe ";

    public  void enterSummary(String summary){
        $(byXpath(inputSummaryXpath)).sendKeys(summary);

    }

    // Это отняло у меня 3 часа моей жизни...
    public  void enterDescription(String description){
        Selenide.switchTo().frame($(byXpath(frameXpath)));
        $(byId(inputDescriptionID)).sendKeys(description);
        Selenide.switchTo().defaultContent();
    }

    public void clickAssignToMe(){
        $(byXpath(assignToMeButtonXpath)).click();
    }

    public void clickCreateButton(){
        $(byXpath(createButtonXpath)).click();
    }


}
