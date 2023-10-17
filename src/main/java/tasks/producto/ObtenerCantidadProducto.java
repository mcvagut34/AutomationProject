package tasks.producto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.ProductoUI;

import java.util.List;

public class ObtenerCantidadProducto {
    public static int actual(WebDriver driver) {
        List<WebElement> products = driver.findElements(ProductoUI.producto);
        return products.size();
    }
}
