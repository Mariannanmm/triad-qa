package org.mobile.screens;


import org.helpers.MobileTools;

public class LoginScreen extends MobileTools {
    public static final LoginScreen loginScreen = new LoginScreen();
    private LoginScreen() {};

    private final String usernameField = "test-Username";
    private final String passwordField = "test-Password";
    private final String loginButton   = "test-LOGIN";

    public void login(String user, String pass) {
        type(usernameField, user);
        type(passwordField, pass);
        click(loginButton);
    }
}










