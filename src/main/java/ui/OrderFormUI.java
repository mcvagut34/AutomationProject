package ui;

import org.openqa.selenium.By;

public class OrderFormUI {

    public static final By orderForm = By.xpath("//div[@id=\"orderModal\"]//form");

    public static final By nameField = By.xpath("//input[@id=\"name\"]");
    public static final By countryField = By.xpath("//input[@id=\"country\"]");
    public static final By cityField = By.xpath("//input[@id=\"city\"]");
    public static final By creditCardField = By.xpath("//input[@id=\"card\"]");
    public static final By monthField = By.xpath("//input[@id=\"month\"]");
    public static final By yearField = By.xpath("//input[@id=\"year\"]");

    public static final By purchaseBtn = By.xpath("//button[text()=\"Purchase\"]");

    public static final By resultModal = By.xpath("//div[contains(concat(' ',normalize-space(@class),' '),' sweet-alert ')]");
    public static final By resultModalHeader = By.xpath("//div[contains(concat(' ',normalize-space(@class),' '),' sweet-alert ')]//h2");


}
