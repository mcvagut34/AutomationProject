package webdriver.factory;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class WebDriverFactory {

    public static WebDriver getDriver(String browser, String os) throws Exception {
        if ((!Objects.equals(os, "linux")) && (!Objects.equals(os, "windows")))
            throw new Exception("Operating system " + os + " not supported.");

        switch (browser) {
            case "chrome":
                ChromeDriverCreator chromeDriverCreator = new ChromeDriverCreator();
                return chromeDriverCreator.createWebDriver(os);
            case "firefox":
                FirefoxDriverCreator firefoxDriverCreator = new FirefoxDriverCreator();
                return firefoxDriverCreator.createWebDriver(os);
            default:
                throw new Exception("Browser " + browser + " nor support");
        }
    }
}
