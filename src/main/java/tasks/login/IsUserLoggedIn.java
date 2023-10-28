package tasks.login;

import actions.GetText;
import actions.WaitUntilElement;
import com.aventstack.extentreports.Status;
import helpers.ScreenShotHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ui.NavbarUI;

public class IsUserLoggedIn {

    public static boolean perform(WebDriver driver, String username) throws Exception {
        if (!WaitUntilElement.isVisible(driver, NavbarUI.usernameText, 2))
            throw new Exception("Texto con nombre de usuario en navbar no encontrado");

        String welcomeText = GetText.from(driver, NavbarUI.usernameText);
        String usernameFromText = welcomeText.replace("Welcome ", "");

        Logger logger = LogManager.getLogger(IsUserLoggedIn.class);
        logger.info("Texto obtenido desde welcomeText: " + usernameFromText);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Navbar con usuario actual");

        return usernameFromText.equals(username);
    }
}
