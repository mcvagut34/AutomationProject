package tasks.navbar;

import actions.Click;
import org.openqa.selenium.WebDriver;
import ui.NavbarUI;

public class GoToCartPage {

    public static void perform(WebDriver driver) {
        Click.on(driver, NavbarUI.cartBtn);
    }
}
