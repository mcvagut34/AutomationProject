package purchase;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.cart.PlaceOrder;
import tasks.home.FilterGridByLaptop;
import tasks.home.GoToFirstProductDetails;
import tasks.navbar.GoToCartPage;
import tasks.order.FillOrderForm;
import tasks.order.IsPurchaseConfirmed;
import tasks.product.AddProductToCart;

public class ProductPurchaseTest extends BaseTest {
    @Test(description = "Validar producto seleccionado antes de comprarlo" )
    public void successfulProductPurchase() throws Exception {

        FilterGridByLaptop.perform(driver);
        GoToFirstProductDetails.perform(driver);
        AddProductToCart.perform(driver);
        GoToCartPage.perform(driver);
        PlaceOrder.perform(driver);

        FillOrderForm.perform(driver, "Juan Perez", "Bolivia", "La Paz", "1234-4567-6789-7654", "10", "2023");
        boolean purchaseResult = IsPurchaseConfirmed.perform(driver);

        Assert.assertTrue(purchaseResult);
    }
}
