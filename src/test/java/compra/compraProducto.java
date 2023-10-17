package compra;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.producto.ObtenerCantidadProducto;
import tasks.producto.ProductoSeleccionado;
import tasks.Seleccion;

public class compraProducto extends BaseTest {
    @Test(description = "Validar producto seleccionado antes de comprarlo" )
    public void validarProdcutoSeleecionado() throws InterruptedException {

        int expectedProducts = 1;
        Seleccion.categoria(driver);
        Thread.sleep(2000);
        ProductoSeleccionado.cantidad(driver, expectedProducts);
        System.out.println("Seleccionando " + expectedProducts + " productos.");
        Thread.sleep(2000);
        Seleccion.producto(driver);
        Assert.assertEquals(ObtenerCantidadProducto.actual(driver), expectedProducts);

        Thread.sleep(2000);
    }

}
