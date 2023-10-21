package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntilElement {

        public static boolean isPresent(WebDriver webDriver, By locator, int timeoutInSeconds) {
            try {
                WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public static boolean isVisible(WebDriver webDriver, By locator, int timeoutInSeconds) {
            try {
                WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public static boolean isClickable(WebDriver webDriver, By locator, int timeoutInSeconds) {
            try {
                WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

    public static boolean hasNInstances(WebDriver webDriver, By locator, int instances, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
            wait.until(ExpectedConditions.numberOfElementsToBe(locator, instances));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


