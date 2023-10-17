package tasks.registro;

import actions.Click;
import actions.Enter;
import actions.EsperarAlertaRegistro;
import org.openqa.selenium.WebDriver;
import ui.RegistroUI;

public class Registro {

        private final String user;
        private final String password;
        private final WebDriver driver;

        public Registro(String user, String password, WebDriver driver) {
            this.user = user;
            this.password = password;
            this.driver = driver;
        }

        public void perform() {
            Enter.text(driver, RegistroUI.username, user);
            Enter.text(driver, RegistroUI.password, password);
            Click.on(driver, RegistroUI.loginBtn);

            if (EsperarAlertaRegistro.isPresent(driver)) {

                String alertText = driver.switchTo().alert().getText();
                System.out.println("Texto de la alerta: " + alertText);
                driver.switchTo().alert().accept();
            }
        }
    }

