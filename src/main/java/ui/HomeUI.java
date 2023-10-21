package ui;

import org.openqa.selenium.By;

public class HomeUI {
    public static final By laptopFilterBtn = By.xpath("//a[contains(@onclick, \"byCat('notebook')\")]");

    public static final By productsGrid = By.className("col-lg-9");

    public static final By productTitle = By.xpath("//h4[@class=\"card-title\"]//a");


}
