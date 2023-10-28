package models;

public class LoginModel {
    private String username;
    private String password;

    public String getPass() {
        return password;
    }

    public String getUser() {
        return username;
    }

    public String toString(){
        return username + " : " + password;
    }
}
