package org.mobile.screens;

import org.helpers.MobileTools;

public class ProductsScreen extends MobileTools {
    public static final ProductsScreen productsScreen = new ProductsScreen();
    private ProductsScreen() {}

    private final String menuButton = "test-Menu";
    private final String addToCartButton = "test-ADD TO CART";
    private final String removeButton     = "test-REMOVE";
    private final String cartButton = "test-Cart";

    public boolean isOpened() {
        return isDisplayed(menuButton);
    }

    public void addFirstItemToCart() {
        click(addToCartButton);          // клікне перший товар у списку
    }

    public boolean isItemAdded() {
        return isDisplayed(removeButton); // кнопка стала REMOVE → товар у кошику
    }

    public void openCart() {
        click(cartButton);
    }

}
