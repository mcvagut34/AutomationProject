package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alert {
    public static void accept(WebDriver webDriver) {
        webDriver.switchTo().alert().accept();
    }
}
