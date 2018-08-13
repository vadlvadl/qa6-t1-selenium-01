package Steps;

import com.codeborne.selenide.Configuration;
import helpers.PropertyReader;

public class InitStep {

    public static void initConfiguration(){

        PropertyReader appConfig = new PropertyReader(System.getProperty("user.dir") + "/src/test/resources/jira.properties");

        Configuration.remote = appConfig.getStringValue("configurationRemote");
        Configuration.browser = appConfig.getStringValue("configurationBrowser");
        Configuration.timeout = appConfig.getIntValue("configurationTimeout");

    }

    public static PropertyReader getAppConfig(){
        return new PropertyReader(System.getProperty("user.dir") + "/src/test/resources/jira.properties");
    }

    public static PropertyReader getCredentials(){
        return new PropertyReader(System.getProperty("user.dir") + "/src/test/resources/credentials.properties");
    }
}
