package helpers;

public class Credentials {

    private String username;
    private String password;

    public void Credentials(String path){

        PropertyReader propertyReader = new PropertyReader(path);
        this.username = propertyReader.getStringValue("username");
        this.password = propertyReader.getStringValue("password");

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
