package helpers;

import com.codeborne.selenide.Configuration;
import helpers.PropertyReader;

public class AppConfiguration {

    private PropertyReader appConfig;

    public void loadFromFile(String path){
        this.appConfig =  new PropertyReader(path);
    }

    public void configure(){

        Configuration.remote = appConfig.getStringValue("configurationRemote");
        Configuration.browser = appConfig.getStringValue("configurationBrowser");
        Configuration.timeout = appConfig.getIntValue("configurationTimeout");

    }



}
