package webdriver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverCreator extends WebDriverCreator {

    @Override
    public WebDriver createWebDriver(String os) {
        String driverPath = "resources/webdrivers/" + os + "/chromedriver";
        if (os.equals("windows")) driverPath += ".exe";

        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }
}
