package tasks.cart;

import actions.GetText;
import actions.WaitUntilElement;
import org.openqa.selenium.WebDriver;
import ui.CartUI;

public class GetFirstProductPrice {

    public static String perform(WebDriver driver) throws Exception {
        if (!WaitUntilElement.isVisible(driver, CartUI.tableBody, 2))
            throw new Exception("Tabla de productos no encontrada");

        return GetText.from(driver, CartUI.firstProductPrice);
    }
}
