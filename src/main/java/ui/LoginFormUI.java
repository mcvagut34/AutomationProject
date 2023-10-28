package ui;

import org.openqa.selenium.By;

public class LoginFormUI {

    public static final By loginForm = By.xpath("//div[@id=\"logInModal\"]//form");

    public static final By usernameField = By.id("loginusername");

    public static final By passwordField = By.id("loginpassword");

    public static final By loginBtn = By.xpath("//button[text()=\"Log in\"]");

}
