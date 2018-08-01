import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import pages.IssueDialogPage;

import static com.codeborne.selenide.Selenide.open;

public class JiraEditIssueTest {

    @Test
    public void AddCommentTest(){

        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.timeout = 7000;

        String comment = "Comment added by autotest";
        String issueURL = "http://jira.hillel.it:8080/browse/QAAUT6-56";


        open(issueURL);

        IssueDialogPage issueDialogPage = new IssueDialogPage();

    }
}
