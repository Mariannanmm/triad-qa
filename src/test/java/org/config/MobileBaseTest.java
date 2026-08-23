package org.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

/**
 * MobileBaseTest — база для мобільних тестів (Appium + Android).
 * Ціль: Sauce Labs "My Demo App" (той самий Swag Labs, але APK).
 *
 * !!! Це заготовка для Фази 3. Доналаштуємо разом, коли поставимо Appium.
 * Поки тут немає жодного мобільного тесту — цей клас не запускається.
 *
 * Що треба буде зробити на Фазі 3:
 *   1) поставити Android Studio + емулятор (або підключити реальний телефон);
 *   2) запустити Appium Server (порт 4723);
 *   3) покласти .apk у папку /apps і вказати шлях у APP_PATH;
 *   4) через Appium Inspector знайти accessibility id елементів.
 */
public abstract class MobileBaseTest {

    // Шлях до APK (покладемо файл у apps/ на Фазі 3)
    protected static final String APP_PATH = System.getProperty("user.dir") + "/apps/mda.apk";
    protected static final String APPIUM_SERVER = "http://127.0.0.1:4723";

    protected AndroidDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUpMobile() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("Android Emulator")   // або назва твого пристрою
                .setApp(new File(APP_PATH).getAbsolutePath())
                .setAppWaitActivity("*")
                .setNewCommandTimeout(Duration.ofSeconds(120));

        URL serverUrl = URI.create(APPIUM_SERVER).toURL();
        driver = new AndroidDriver(serverUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass(alwaysRun = true)
    public void tearDownMobile() {
        if (driver != null) {
            driver.quit();
        }
    }
}
