package webdriver.factory;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public abstract class WebDriverCreator {

    public abstract WebDriver createWebDriver(String os) throws MalformedURLException;
}
