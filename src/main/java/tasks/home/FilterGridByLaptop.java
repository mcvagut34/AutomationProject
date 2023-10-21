package tasks.home;

import actions.Click;
import actions.WaitUntilElement;
import org.openqa.selenium.WebDriver;
import ui.HomeUI;

public class FilterGridByLaptop {
    public static void perform(WebDriver driver) throws Exception {
        if (!WaitUntilElement.isClickable(driver, HomeUI.laptopFilterBtn, 2))
            throw new Exception("Botón de selección de laptops no encontrado");

        Click.on(driver, HomeUI.laptopFilterBtn);

        // Esperar a que el grid filtre de 9 a 6 elementos (solo laptops)
        WaitUntilElement.hasNInstances(driver, HomeUI.productTitle, 6, 5);
    }
}
