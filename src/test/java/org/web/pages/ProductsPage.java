package org.web.pages;

import org.helpers.PageTools;

public class ProductsPage extends PageTools {

    public static final ProductsPage productsPage = new ProductsPage();
    private ProductsPage() {}

    private final String pageTitle = ".title";   // <span class="title">Products</span>
    private final String addBackpackButton = "add-to-cart-sauce-labs-backpack";   // id
    private final String cartBadge          = ".shopping_cart_badge";              // css
    private final String cartLink = ".shopping_cart_link";   // css


    public String getTitle() {
        return getText("css", pageTitle);   // прочитати текст заголовка
    }
    public void clickAddBackpackButton() {
        click("id", addBackpackButton);
    }
    public String getCartBadge() {
        return getText("css", cartBadge);
    }
    public void openCart() {
        click("css", cartLink);
    }

}