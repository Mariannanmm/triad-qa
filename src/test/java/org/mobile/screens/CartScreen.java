package org.mobile.screens;

import org.helpers.MobileTools;

public class CartScreen extends MobileTools {

    public static final CartScreen cartScreen = new CartScreen();
    private CartScreen() {}

    private final String checkoutButton = "test-CHECKOUT";

    public void clickCheckout() {
        click(checkoutButton);
    }
}
