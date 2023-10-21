package tasks.cart;

import actions.Click;
import org.openqa.selenium.WebDriver;
import ui.CartUI;

public class PlaceOrder {

    public static void perform(WebDriver driver) {
        Click.on(driver, CartUI.placeOrderBtn);
    }
}
