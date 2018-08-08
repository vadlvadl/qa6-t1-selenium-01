package pages;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    public  void clickAdvancedButton() {
        if($(byXpath("//div[@class =\"mode-switcher\"]/a[1]")).isDisplayed()){
        $(byXpath("//div[@class =\"mode-switcher\"]/a[1]")).click();}
    }
    public  void fillJQLField(String JQLRequest) {
        $(byXpath("//*[@id=\"advanced-search\"]")).clear();
        $(byXpath("//*[@id=\"advanced-search\"]")).sendKeys(JQLRequest);
    }
    public  void clickSearchButton() {
        $(byXpath("//button[@class=\"aui-item aui-button aui-button-subtle search-button\"]")).click();
    }
}
