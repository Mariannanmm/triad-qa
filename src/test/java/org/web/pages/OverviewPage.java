package org.web.pages;

import org.helpers.PageTools;

public class OverviewPage extends PageTools {
    public static final OverviewPage overviewPage = new OverviewPage();
    private OverviewPage() {}

    private final String finishButton = "finish";//id

    public void clickFinishButton() {
        click("id", finishButton);
    }

}
