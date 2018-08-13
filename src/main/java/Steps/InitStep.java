package Steps;

import com.codeborne.selenide.Configuration;
import helpers.PropertyReader;

public class InitStep {

    private PropertyReader appConfig;
    private PropertyReader credentials;

    public void initConfiguration(){

        // Get full path to root directory
        String rootPath = System.getProperty("user.dir");

        appConfig = new PropertyReader(rootPath + "/src/test/resources/jira.properties");
        credentials = new PropertyReader(rootPath + "/src/test/resources/credentials.properties");

        Configuration.remote = appConfig.getStringValue("configurationRemote");
        Configuration.browser = appConfig.getStringValue("configurationBrowser");
        Configuration.timeout = appConfig.getIntValue("configurationTimeout");
    }
}
