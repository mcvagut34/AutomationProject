package tasks.order;

import actions.GetText;
import actions.WaitUntilElement;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import ui.OrderFormUI;
import org.apache.logging.log4j.Logger;


public class IsPurchaseConfirmed {

    public static boolean perform(WebDriver driver) throws Exception {
        if (!WaitUntilElement.isVisible(driver, OrderFormUI.resultModal, 2))
            throw new Exception("Modal de confirmación de compra no encontrado");

        // Comparar el header con el texto de compra exitosa
        String header = GetText.from(driver, OrderFormUI.resultModalHeader);

        Logger logger = LogManager.getLogger(IsPurchaseConfirmed.class);
        logger.info("Header presente en confirmación: " + header);

        return header.equals("Thank you for your purchase!");


    }
}
