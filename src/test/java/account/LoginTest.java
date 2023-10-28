package account;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import helpers.JsonTestDataHelper;
import helpers.ReportManager;
import helpers.ScreenShotHelper;
import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tasks.login.FillLoginForm;
import tasks.login.IsPasswordInvalid;
import tasks.login.IsUserInvalid;
import tasks.login.IsUserLoggedIn;
import tasks.navbar.ShowLoginForm;

import java.io.FileNotFoundException;

public class LoginTest extends BaseTest {

    public static String loginTestDataPath = "resources/testdata/login/";

//    @Test(description = "Validar inicio de sesión con credenciales correctas", dataProvider = "loginCorrectProvider")
    public void testLoginCorrect(LoginModel loginData) throws Exception {

        ReportManager.getInstance().getTest().log(Status.INFO, "Login test data: " + loginData.toString());
        ShowLoginForm.perform(driver);
        FillLoginForm.perform(driver, loginData.getUser(), loginData.getPass());

        boolean loginSuccessful = IsUserLoggedIn.perform(driver, loginData.getUser());
        Assert.assertTrue(loginSuccessful);
    }

    @Test(description = "Validar inicio de sesión con usuario inexistente", dataProvider = "loginUserInvalidProvider")
    public void testLoginUsernameInvalid(LoginModel loginData) throws Exception {

        ReportManager.getInstance().getTest().log(Status.INFO, "Login test data: " + loginData.toString());
        ShowLoginForm.perform(driver);
        FillLoginForm.perform(driver, loginData.getUser(), loginData.getPass());

        boolean isUserInvalid = IsUserInvalid.perform(driver);
        Assert.assertTrue(isUserInvalid);
    }

    @Test(description = "Validar inicio de sesión con contraseña incorrecta", dataProvider = "loginPasswordInvalidProvider")
    public void testLoginPasswordInvalid(LoginModel loginData) throws Exception {

        ReportManager.getInstance().getTest().log(Status.INFO, "Login test data: " + loginData.toString());
        ShowLoginForm.perform(driver);
        FillLoginForm.perform(driver, loginData.getUser(), loginData.getPass());

        boolean isPasswordInvalid = IsPasswordInvalid.perform(driver);
        Assert.assertTrue(isPasswordInvalid);
    }

    @DataProvider(name="loginCorrectProvider")
    public Object[] loginCorrectDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().getTestData(loginTestDataPath + "loginCorrect.json", LoginModel.class);
    }

    @DataProvider(name="loginUserInvalidProvider")
    public Object[] loginUserInvalidProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().getTestData(loginTestDataPath + "loginUserInvalid.json", LoginModel.class);
    }

    @DataProvider(name="loginPasswordInvalidProvider")
    public Object[] loginPasswordInvalidProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().getTestData(loginTestDataPath + "loginPassInvalid.json", LoginModel.class);
    }
}
