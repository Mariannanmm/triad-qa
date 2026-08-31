package org.mobile.screens;

import org.helpers.MobileTools;

public class OverviewScreen extends MobileTools {
    public static final OverviewScreen overviewScreen = new OverviewScreen();
    private OverviewScreen() {};

    private final String buttonFinish = "test-FINISH";

    public void clickButtonFinish() {
        scrollTo(buttonFinish);
        click(buttonFinish);
    }
}
