package base;

import helpers.ReportManager;
import helpers.ScreenShotHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.Status;
import webdriver.factory.WebDriverFactory;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;
    private static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public static void setupSuite() throws Exception {
        log.info("Iniciando la suite de pruebas");
        ReportManager.init("Reports", "PurchaseSuite");
    }

    @BeforeMethod
    @Parameters({"url", "browser", "os"})
    public void setup(ITestResult iTestResult, String url, String browser, String os) throws Exception {
        log.info("Iniciando el método de configuración para el caso de prueba: " + iTestResult.getMethod().getDescription());
        log.info("Configuración: Navegador={}, SO={}", browser, os);

        ReportManager.getInstance().startTest(iTestResult.getMethod().getDescription());
        driver = WebDriverFactory.getDriver(browser, os);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        log.info("Navegando a {}", url);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Navegando a Página de Inicio");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        log.info("Finalizando el caso de prueba: " + iTestResult.getMethod().getDescription());

        try {
            switch (iTestResult.getStatus()) {
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test passes");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

            if (iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null) {
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.FAIL, "Failure Image");
            }
        } catch (Exception e) {
            log.error("Error inesperado:", e);
            e.printStackTrace();
        } finally {
            if (driver != null)
                driver.quit();
            log.info("Cerrando el driver");
            Thread.sleep(1000);
        }
    }

    @AfterSuite
    public static void tearDownSuite() {
        log.info("Finalizando la suite de pruebas");
        ReportManager.getInstance().flush();
    }
}
