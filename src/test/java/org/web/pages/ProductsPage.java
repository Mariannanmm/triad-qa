package org.web.pages;

import com.codeborne.selenide.Condition;
import org.helpers.PageTools;

public class ProductsPage extends PageTools {

    public static final ProductsPage productsPage = new ProductsPage();
    private ProductsPage() {}

    private final String pageTitle = ".title";   // <span class="title">Products</span>
    private final String addBackpackButton = "add-to-cart-sauce-labs-backpack";   // id
    private final String cartBadge          = ".shopping_cart_badge";              // css
    private final String cartLink = ".shopping_cart_link";   // css
    private final String firstItemName = ".inventory_item_name";
    private final String removeBackpackButton = "remove-sauce-labs-backpack";
    private final String sortDropdown = ".product_sort_container";   // css
    private final String itemPrice    = ".inventory_item_price";



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

    public String getFirstItemName() {
        return getText("css", firstItemName);
    }

    public void openFirstItem() {
        click("css", firstItemName);
    }
    public void clickRemoveBackpack() {
        click("id", removeBackpackButton);
    }

    public void checkCartIsEmpty() {
        should("css", Condition.hidden, cartBadge);   // чекаємо, поки лічильник зникне
    }
    public void sortByPriceLowToHigh() {
        selectByValue("css",  "lohi", sortDropdown);
    }
    public String getFirstItemPrice() {
        return getText("css", itemPrice);
    }

}