package tasks.home;

import actions.Click;
import actions.WaitUntilElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.HomeUI;

public class GoToFirstProductDetails {
    
    public static void perform (WebDriver driver) throws Exception {
        if (!WaitUntilElement.isVisible(driver, HomeUI.productsGrid, 2))
            throw new Exception("Grid de productos no encontrado");

        WebElement firstProduct = driver.findElements(HomeUI.productsGrid).get(0);
        Click.on(firstProduct, HomeUI.productTitle);
    }
}
