package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alert {
    public static void accept(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static String getText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }
}
