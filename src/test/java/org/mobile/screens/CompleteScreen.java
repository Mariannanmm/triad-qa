package org.mobile.screens;

import org.helpers.MobileTools;

public class CompleteScreen extends MobileTools {

    public static final CompleteScreen completeScreen = new CompleteScreen();
    private CompleteScreen() {}

    private final String completeContainer = "test-CHECKOUT: COMPLETE!";

    public boolean isOrderComplete() {
        return isDisplayed(completeContainer);
    }
}