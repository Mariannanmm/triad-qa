package org.web.pages;

import org.helpers.PageTools;

public class MenuPage extends PageTools{
    public static final MenuPage menuPage = new MenuPage();
    private MenuPage(){}

    private final String burgerButton = "react-burger-menu-btn";
    private final String logoutLink   = "logout_sidebar_link";

    public void openMenu(){
        click("id", burgerButton);
    }

    public void clickLogout() {
        click("id", logoutLink);
    }
}
