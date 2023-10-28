package tasks.login;

import actions.Alert;
import actions.WaitUntilAlert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class IsUserInvalid {

    public static boolean perform (WebDriver driver) throws Exception {
        if (!WaitUntilAlert.isPresent(driver)) {
            throw new Exception("No se ha encontrado ninguna alerta");
        }

        String message = Alert.getText(driver);
        Logger logger = LogManager.getLogger(IsUserInvalid.class);
        logger.info("Mensaje en alerta: " + message);
        return message.equals("User does not exist.");
    }
}
