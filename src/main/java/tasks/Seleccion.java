package tasks;

import actions.Click;
import org.openqa.selenium.WebDriver;
import ui.HomeUI;
import ui.ProductoUI;

public class Seleccion {

    public static void categoria(WebDriver driver) {
        Click.on(driver, HomeUI.laptops);
    }
    public static void producto(WebDriver driver) {
        Click.on(driver, ProductoUI.producto);
    }


}
