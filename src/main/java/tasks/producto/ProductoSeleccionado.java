package tasks.producto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ui.ListaProductosUI.item;

public class ProductoSeleccionado {

    public static void cantidad(WebDriver driver, int cant) {
        List<WebElement> products = driver.findElements(item);

        for (int i = 0; i < cant; i++) {
            products.get(i).click();
        }
    }

}
