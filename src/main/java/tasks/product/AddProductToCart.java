package tasks.product;

import actions.Alert;
import actions.Click;
import actions.WaitUntilAlert;
import org.openqa.selenium.WebDriver;
import ui.ProductUI;

public class AddProductToCart {

    public static void perform(WebDriver driver) throws Exception {
        Click.on(driver, ProductUI.addToCartBtn);

        if (!WaitUntilAlert.isPresent(driver))
            throw new Exception("AddProductToCart: No se ha generado alert de confirmación");

        // Aceptar alert de confirmación
        Alert.accept(driver);
    }
}
