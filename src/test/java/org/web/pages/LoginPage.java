package org.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.helpers.PageTools;

public class LoginPage extends PageTools {

    // --- Singleton (форма вчителя) ---
    public static final LoginPage loginPage = new LoginPage();
    private LoginPage() {}

    // --- Локатори (усі три поля мають id) ---
    private final String usernameField = "user-name";
    private final String passwordField = "password";
    private final String loginButton   = "login-button";

    // --- Дії ---
    public void open() {
        Selenide.open("/");   // baseUrl (saucedemo.com) заданий у TestBase
    }

    public void login(String username, String password) {
        type("id", username, usernameField);
        type("id", password, passwordField);
        click("id", loginButton);
    }
    private final String errorMessage = "[data-test='error']";   // css-локатор

    public String getErrorText() {
        return getText("css", errorMessage);
    }
    public void checkLoginPageOpened() {
        should("id", Condition.visible, loginButton);   // кнопка Login знову видима
    }

}
