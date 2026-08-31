package tests.mobile;

import org.config.MobileBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mobile.screens.LoginScreen.loginScreen;
import static org.mobile.screens.ProductsScreen.productsScreen;

public class LoginMobileTest extends MobileBaseTest {

    @Test
    public void appLaunchesSuccessfully() {
        String currentPackage = driver.getCurrentPackage();
        System.out.println("Поточний застосунок: " + currentPackage);
        Assert.assertTrue(currentPackage.contains("swag"),
                "Очікували, що відкриється застосунок Swag Labs");
    }

    @Test
    public void loginMobile() {
        loginScreen.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsScreen.isOpened(), "Після логіну мав відкритись каталог");
    }
}
