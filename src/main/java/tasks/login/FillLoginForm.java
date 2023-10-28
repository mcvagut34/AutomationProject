package tasks.login;

import actions.Click;
import actions.Enter;
import actions.WaitUntilElement;
import com.aventstack.extentreports.Status;
import helpers.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import ui.LoginFormUI;

public class FillLoginForm {

    public static void perform(WebDriver driver, String username, String password) throws Exception {
        if (!WaitUntilElement.isVisible(driver, LoginFormUI.loginForm, 2))
            throw new Exception("Formulario para inicio de sesión no encontrado");

        Enter.text(driver, LoginFormUI.usernameField, username);
        Enter.text(driver, LoginFormUI.passwordField, password);

        Click.on(driver, LoginFormUI.loginBtn);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Formulario llenado y enviado");
    }
}
