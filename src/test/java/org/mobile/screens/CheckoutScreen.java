package org.mobile.screens;

import org.helpers.MobileTools;

public class CheckoutScreen extends MobileTools {
    public static final CheckoutScreen checkoutScreen = new CheckoutScreen();
    private CheckoutScreen() {}

    private final String fieldFirstname = "test-First Name";
    private final String fieldLastname = "test-Last Name";
    private final String fieldPostalCode = "test-Zip/Postal Code";
    private final String buttonContinue = "test-CONTINUE";

    public void fillInfoAndContinue(String firstName, String lastName, String zip) {
        type(fieldFirstname, firstName);
        type(fieldLastname, lastName);
        type(fieldPostalCode, zip);
        click(buttonContinue);
    }
}
