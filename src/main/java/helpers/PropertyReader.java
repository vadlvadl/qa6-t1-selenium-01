package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private String filePath;
    private Properties prop;
    private InputStream input = null;

    public PropertyReader(String filePath){

        this.filePath = filePath;
        this.prop = new Properties();

        loadProperties();

    }

    private void loadProperties(){

        try{
            input = new FileInputStream(filePath);

            prop.load(input);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getStringValue(String key) {
        return prop.getProperty(key);
    }

    public String getStringValue(String key, String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }

    public Integer getIntValue(String key) {
        return Integer.parseInt(prop.getProperty(key));
    }

    public Integer getIntValue(String key, Integer defaultValue) {
        return Integer.parseInt(prop.getProperty(key, defaultValue.toString()));
    }

}