package ui;

import org.openqa.selenium.By;

public class ProductUI {

    public static final By productName = By.xpath("//div[@id=\"tbodyid\"]/h2[@class=\"name\"]");
    public static final By productPrice = By.xpath("//div[@id=\"tbodyid\"]/h3[@class=\"price-container\"]");
    public static final By addToCartBtn = By.xpath("//a[text()=\"Add to cart\"]");
}
