package purchase;

import base.BaseTest;
import org.testng.Assert;
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

public class ProductPurchaseTest extends BaseTest {

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

    @Test(description = "Validar compra exitosa de un producto de tipo laptop" )
    public void successfulLaptopProductPurchase() throws Exception {

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
