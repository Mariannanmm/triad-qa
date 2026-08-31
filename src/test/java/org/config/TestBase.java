package org.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

/**
 * TestBase — базовий клас для Web UI тестів (Swag Labs / saucedemo.com).
 * Налаштування браузера, baseUrl, headless-режим і чистка стану між тестами.
 * @AfterMethod чистить cookies/localStorage, щоб тести не залежали один від одного.
 * Headless вмикається через -Dheadless=true (зручно для CI).
 */
public abstract class TestBase {

    protected static final String BASE_URL = "https://www.saucedemo.com";

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = "1366x900";
        Configuration.timeout = 10_000;
        // headless: mvn test -Dheadless=true
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        // тримати браузер відкритим після тесту локально (для дебагу): -DholdBrowserOpen=true
        Configuration.holdBrowserOpen = Boolean.parseBoolean(System.getProperty("holdBrowserOpen", "false"));

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
