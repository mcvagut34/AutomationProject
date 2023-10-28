package account;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.login.FillLoginForm;
import tasks.login.IsUserLoggedIn;
import tasks.navbar.ShowLoginForm;

public class LoginTest extends BaseTest {

    @Test(description = "Validar inicio de sesión", priority = 2)
    public void userLogin() throws Exception {

        ShowLoginForm.perform(driver);
        FillLoginForm.perform(driver, "mytestinguser", "super-secret-pass");

        boolean loginSuccessful = IsUserLoggedIn.perform(driver, "mytestinguser");
        Assert.assertTrue(loginSuccessful);
    }
}
