package purchase;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import helpers.JsonTestDataHelper;
import helpers.ReportManager;
import models.LoginModel;
import models.OrderModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tasks.cart.GetFirstProductName;
import tasks.cart.GetFirstProductPrice;
import tasks.cart.PlaceOrder;
import tasks.home.FilterGridByLaptop;
import tasks.home.GoToFirstProductDetails;
import tasks.navbar.GoToCartPage;
import tasks.order.FillOrderForm;
import tasks.order.IsPurchaseConfirmed;
import tasks.product.AddProductToCart;
import tasks.product.GetProductName;
import tasks.product.GetProductPrice;

import java.io.FileNotFoundException;

public class ProductPurchaseTest extends BaseTest {

    public static String purchaseTestDataPath = "resources/testdata/purchase/";

    @Test(description = "Validar producto añadido al carrito")
    public void addLaptopProductToCart() throws Exception {

        FilterGridByLaptop.perform(driver);
        GoToFirstProductDetails.perform(driver);
        String selectedProductName = GetProductName.perform(driver);
        String selectedProductPrice = GetProductPrice.perform(driver);

        AddProductToCart.perform(driver);
        GoToCartPage.perform(driver);
        String cartProductName = GetFirstProductName.perform(driver);
        String cartProductPrice = GetFirstProductPrice.perform(driver);

        // Comparar nombre y precio de producto añadido
        Assert.assertEquals(selectedProductName,cartProductName);
        Assert.assertEquals(selectedProductPrice,cartProductPrice);
    }

    @Test(description = "Validar compra exitosa de un producto de tipo laptop", dataProvider = "orderDataProvider")
    public void successfulLaptopProductPurchase(OrderModel orderData) throws Exception {

        FilterGridByLaptop.perform(driver);
        GoToFirstProductDetails.perform(driver);
        AddProductToCart.perform(driver);
        GoToCartPage.perform(driver);
        PlaceOrder.perform(driver);

        ReportManager.getInstance().getTest().log(Status.INFO, "Order test data: " + orderData.toString());
        FillOrderForm.perform(
                driver,
                orderData.getName(),
                orderData.getCountry(),
                orderData.getCity(),
                orderData.getCreditCard(),
                orderData.getMonth(),
                orderData.getYear());
        boolean purchaseResult = IsPurchaseConfirmed.perform(driver);

        Assert.assertTrue(purchaseResult);
    }

    @DataProvider(name="orderDataProvider")
    public Object[] orderDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().getTestData(purchaseTestDataPath + "orderData.json", OrderModel.class);
    }
}
