package helpers;

import com.codeborne.selenide.Configuration;

public class AppConfiguration {

    private PropertyReader appConfig;

    public AppConfiguration(String path){
        this.appConfig =  new PropertyReader(path);

        this.configure();
    }

    public void configure(){

        Configuration.remote = appConfig.getStringValue("configurationRemote");
        Configuration.browser = appConfig.getStringValue("configurationBrowser");
        Configuration.timeout = appConfig.getIntValue("configurationTimeout");

    }

    public String get(String key){
        return appConfig.getStringValue(key);
    }

}
