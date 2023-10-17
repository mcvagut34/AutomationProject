package tasks.producto;

import actions.EsDesplegado;
import org.openqa.selenium.WebDriver;
import ui.ListaProductosUI;

public class IsListProducts {

    public static boolean inDisplay(WebDriver driver) {
        return EsDesplegado.element(driver, ListaProductosUI.todosLosItems);
    }
}