package tasks.cart;

import actions.Click;
import com.aventstack.extentreports.Status;
import helpers.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import ui.CartUI;

import java.io.IOException;

public class PlaceOrder {

    public static void perform(WebDriver driver) throws IOException {
        Click.on(driver, CartUI.placeOrderBtn);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Orden realizada");
    }
}
