package org.web.pages;

import org.helpers.PageTools;

public class CartPage extends PageTools {
    public static final CartPage cartPage=new  CartPage();
    private CartPage(){}

    private final String checkoutButton = "checkout"; //id

    public void clickCheckoutButton() {
        click("id", checkoutButton);
    }
}
