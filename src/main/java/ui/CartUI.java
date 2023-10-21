package ui;

import org.openqa.selenium.By;

public class CartUI {

    public static final By tableBody = By.xpath("//tbody");
    public static final By firstProductName = By.xpath("//tbody/tr[1]/td[2]");
    public static final By firstProductPrice = By.xpath("//tbody/tr[1]/td[3]");
    public static final By placeOrderBtn = By.xpath("//button[text()=\"Place Order\"]");
}
