package tasks.order;

import actions.Click;
import actions.Enter;
import actions.WaitUntilElement;
import com.aventstack.extentreports.Status;
import helpers.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import ui.OrderFormUI;

public class FillOrderForm {

    public static void perform(WebDriver driver, String name, String country, String city, String creditCard, String month, String year) throws Exception {
        if (!WaitUntilElement.isVisible(driver, OrderFormUI.orderForm, 2))
            throw new Exception("Formulario para completar orden no encontrado");

        Enter.text(driver, OrderFormUI.nameField, name);
        Enter.text(driver, OrderFormUI.countryField, country);
        Enter.text(driver, OrderFormUI.cityField, city);
        Enter.text(driver, OrderFormUI.creditCardField, creditCard);
        Enter.text(driver, OrderFormUI.monthField, month);
        Enter.text(driver, OrderFormUI.yearField, year);

        Click.on(driver, OrderFormUI.purchaseBtn);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Formulario llenado y orden realizada");

    }
}
