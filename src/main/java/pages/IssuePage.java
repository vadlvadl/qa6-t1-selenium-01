package pages;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class IssuePage {

    String commentButtonID = "footer-comment-button";
    String textTabButtonID = "aui-uid-1";
    String commentTextAreaXPath = "//*[@id=\"comment-wiki-edit\"]/textarea";
    String addCommentSubmitButtonID = "issue-comment-add-submit";

    public void clickAddCommentButton(){
        $(byId(commentButtonID)).click();
    }

    public void clickTextareaTabButton(){
        $(byId(textTabButtonID)).click();
    }

    public void enterTextToTextarea(String text){
        $(byXpath(commentTextAreaXPath)).sendKeys(text);
    }

    public void clickSubmitCommentButton(){
        $(byId(addCommentSubmitButtonID)).click();
    }
}
