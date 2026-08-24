package tests.ui;

import org.config.TestBase;
import org.data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.web.pages.CartPage.cartPage;
import static org.web.pages.CheckoutPage.checkoutPage;
import static org.web.pages.CompletePage.completePage;
import static org.web.pages.LoginPage.loginPage;
import static org.web.pages.OverviewPage.overviewPage;
import static org.web.pages.ProductDetailPage.productDetailPage;
import static org.web.pages.ProductsPage.productsPage;

public class CriticalTest extends TestBase {

    @Test
    public void loginExistingUser() {
        loginPage.open();
        loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        Assert.assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void addProductToCart() {
        loginPage.open();
        loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        productsPage.clickAddBackpackButton();

        Assert.assertEquals(productsPage.getCartBadge(), "1");
    }
    @Test
    public void placeOrder() {
        loginPage.open();
        loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        productsPage.clickAddBackpackButton();
        productsPage.openCart();
        cartPage.clickCheckoutButton();
        checkoutPage.fillInfoAndContinue("Marianna", "Test", "01001");
        overviewPage.clickFinishButton();
        Assert.assertEquals(completePage.getCompleteHeader(), "Thank you for your order!");
    }

    @Test
    public void checkHomeItemMatchesDetail() {
        loginPage.open();
        loginPage.login(TestData.STANDARD_USER, TestData.PASSWORD);
        String listName = productsPage.getFirstItemName();
        productsPage.openFirstItem();
        Assert.assertEquals(productDetailPage.getName(), listName);
    }

}