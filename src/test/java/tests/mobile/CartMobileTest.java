package tests.mobile;

import org.config.MobileBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mobile.screens.CartScreen.cartScreen;
import static org.mobile.screens.CheckoutScreen.checkoutScreen;
import static org.mobile.screens.CompleteScreen.completeScreen;
import static org.mobile.screens.LoginScreen.loginScreen;
import static org.mobile.screens.OverviewScreen.overviewScreen;
import static org.mobile.screens.ProductsScreen.productsScreen;

public class CartMobileTest extends MobileBaseTest {

    @Test
    public void addToCart() {
        loginScreen.login("standard_user", "secret_sauce");
        productsScreen.addFirstItemToCart();
        Assert.assertTrue(productsScreen.isItemAdded(), "Товар мав додатися (кнопка стала REMOVE)");
    }
    @Test
    public void placeOrder() {
        loginScreen.login("standard_user", "secret_sauce");
        productsScreen.addFirstItemToCart();
        productsScreen.openCart();
        cartScreen.clickCheckout();
        checkoutScreen.fillInfoAndContinue("Mary", "Berry", "76661");
        overviewScreen.clickButtonFinish();
        Assert.assertTrue(completeScreen.isOrderComplete(),
                "Замовлення мало оформитися — очікували екран підтвердження COMPLETE");
    }
}