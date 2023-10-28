package tasks.navbar;

import actions.Click;
import actions.WaitUntilElement;
import org.openqa.selenium.WebDriver;
import ui.NavbarUI;

public class ShowLoginForm {

    public static void perform(WebDriver driver) throws Exception {
        if (!WaitUntilElement.isVisible(driver, NavbarUI.loginBtn, 2))
            throw new Exception("Botón para inicio de sesión no encontrado");

        Click.on(driver, NavbarUI.loginBtn);
    }
}
