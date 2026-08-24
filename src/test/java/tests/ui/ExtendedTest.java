package tests.ui;

import org.config.TestBase;
import org.data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.web.pages.LoginPage;

import static org.web.pages.LoginPage.loginPage;

public class ExtendedTest extends TestBase {
    @Test
    public void loginWithWrongPassword() {
        loginPage.open();
        loginPage.login(TestData.STANDARD_USER, TestData.WRONG_PASSWORD);
        Assert.assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");

    }
}
