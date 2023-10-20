package webdriver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator extends WebDriverCreator {
    @Override
    public WebDriver createWebDriver(String os) {
        String driverPath = "resources/webdrivers/" + os + "/geckodriver";
        if (os.equals("windows")) driverPath += ".exe";

        System.setProperty("webdriver.gecko.driver", driverPath);
        return new FirefoxDriver();
    }
}
