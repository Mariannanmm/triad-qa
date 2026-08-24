package org.web.pages;

import org.helpers.PageTools;

public class CheckoutPage extends PageTools {
    public static final CheckoutPage checkoutPage = new CheckoutPage();
    private CheckoutPage() {}

    private final String firstNameField  = "first-name";
    private final String lastNameField   = "last-name";
    private final String postalCodeField = "postal-code";
    private final String continueButton  = "continue";//all id

    public void fillInfoAndContinue(String firstName, String lastName, String postalCode) {
        type("id", firstName, firstNameField);
        type("id", lastName, lastNameField);
        type("id", postalCode, postalCodeField);
        click("id", continueButton);

    }
}
