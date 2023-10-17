package ui;

import org.openqa.selenium.By;

public class ProductoUI {

    public static final By producto = By.xpath("//div[@class='product-content product-wrap clearfix product-deatil']");

    public static final By addToCart = By.xpath("//a[@onclick=\"addToCart(9)\"]");

}