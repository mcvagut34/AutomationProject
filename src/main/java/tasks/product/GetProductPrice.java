package tasks.product;

import actions.GetText;
import actions.WaitUntilElement;
import org.openqa.selenium.WebDriver;
import ui.ProductUI;

public class GetProductPrice {

    public static String perform(WebDriver driver) throws Exception {
        if (!WaitUntilElement.isVisible(driver, ProductUI.productName, 2))
            throw new Exception("Precio de producto no encontrado");

        String rawPrice = GetText.from(driver, ProductUI.productPrice);
        return rawPrice.split(" ")[0].replace("$", "");
    }
}
