package tests.ui;

import org.config.TestBase;
import org.data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.web.pages.LoginPage;

import static org.web.pages.CartPage.cartPage;
import static org.web.pages.CheckoutPage.checkoutPage;
import static org.web.pages.LoginPage.loginPage;
import static org.web.pages.MenuPage.menuPage;
import static org.web.pages.ProductsPage.productsPage;

public class ExtendedTest extends TestBase {
    @Test
    public void loginWithWrongPassword() {
        loginPage.open();
        loginPage.login(TestData.STANDARD_USER, TestData.WRONG_PASSWORD);
        Assert.assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");

    }
    @Test
    public void removeProductFromCart() {
        loginPage.open();
        loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        productsPage.clickAddBackpackButton();
        productsPage.clickRemoveBackpack();
        productsPage.checkCartIsEmpty();
    }

    @Test
    public void logout() {
        loginPage.open();
        loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        menuPage.openMenu();
        menuPage.clickLogout();
        loginPage.checkLoginPageOpened();
    }

    @Test
    public void placeOrderWithoutInfo() {
        loginPage.open();
        loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        productsPage.clickAddBackpackButton();
        productsPage.openCart();
        cartPage.clickCheckoutButton();
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getErrorText(), "Error: First Name is required");
    }
    @Test
    public void sortByPriceLowToHigh() {
        loginPage.open();
        loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        productsPage.sortByPriceLowToHigh();
        Assert.assertEquals(productsPage.getFirstItemPrice(), "$7.99");
    }
}
