package tasks.product;

import actions.GetText;
import actions.WaitUntilElement;
import org.openqa.selenium.WebDriver;
import ui.ProductUI;

public class GetProductName {

    public static String perform(WebDriver driver) throws Exception {
        if (!WaitUntilElement.isVisible(driver, ProductUI.productName, 2))
            throw new Exception("Nombre de producto no encontrado");

        return GetText.from(driver, ProductUI.productName);
    }
}
