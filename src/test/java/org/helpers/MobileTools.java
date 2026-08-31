package org.helpers;

import io.appium.java_client.AppiumBy;
import org.config.MobileBaseTest;

public class MobileTools {

    public void click(String accessibilityId) {
        MobileBaseTest.driver.findElement(AppiumBy.accessibilityId(accessibilityId)).click();
    }

    public void type(String accessibilityId, String text) {
        MobileBaseTest.driver.findElement(AppiumBy.accessibilityId(accessibilityId)).sendKeys(text);
    }

    public boolean isDisplayed(String accessibilityId) {
        return MobileBaseTest.driver.findElement(AppiumBy.accessibilityId(accessibilityId)).isDisplayed();
    }
    public void scrollTo(String accessibilityId) {
        MobileBaseTest.driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().description(\"" + accessibilityId + "\"))"));
    }
}