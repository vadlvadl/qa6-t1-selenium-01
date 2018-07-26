
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IssuePage {
    private WebDriver driver;
    public IssuePage(WebDriver driver){
        this.driver = driver;
    }

    private String inputSummaryXpath = "//*[@id=\"summary\"]";
    private String inputDescriptionID = "tinymce";
    private String assignToMeButtonXpath = "//*[@id=\"assign-to-me-trigger\"]";
    private String createButtonXpath = "//*[@id=\"create-issue-submit\"]";


    public  void enterSummary(String summary){
        driver.findElement(By.xpath(inputSummaryXpath)).sendKeys(summary);

    }
    // Это отняло у меня 3 часа моей жизни...
    public  void enterDescription(String description){
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputDescriptionID)));
        driver.findElement(By.id(inputDescriptionID)).sendKeys(description);
        driver.switchTo().defaultContent();

    }

    public void clickAssignToMe(){
        driver.findElement(By.xpath(assignToMeButtonXpath)).click();
    }
    public void clickCreateButton(){
        driver.findElement(By.xpath(createButtonXpath)).click();
    }

}
