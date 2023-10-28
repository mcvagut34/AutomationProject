package account;

import base.BaseTest;
import helpers.JsonTestDataHelper;
import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tasks.login.FillLoginForm;
import tasks.login.IsUserLoggedIn;
import tasks.navbar.ShowLoginForm;

import java.io.FileNotFoundException;

public class LoginTest extends BaseTest {

    public static String loginTestDataPath = "resources/testdata/login/";

    @Test(description = "Validar inicio de sesión", dataProvider = "loginCorrectProvider")
    public void userLogin(LoginModel loginData) throws Exception {

        ShowLoginForm.perform(driver);
        FillLoginForm.perform(driver, loginData.getUser(), loginData.getPass());

        boolean loginSuccessful = IsUserLoggedIn.perform(driver, loginData.getUser());
        Assert.assertTrue(loginSuccessful);
    }

    @DataProvider(name="loginCorrectProvider")
    public Object[] loginCorrectDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().getTestData(loginTestDataPath + "loginCorrect.json", LoginModel.class);
    }
}
