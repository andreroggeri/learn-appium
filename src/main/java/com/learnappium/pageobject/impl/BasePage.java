package com.learnappium.pageobject.impl;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;

import java.util.List;

public class BasePage {

    protected MobileDriver<MobileElement> driver;

    public BasePage(MobileDriver<MobileElement> driver) {
        this.driver = driver;
    }

    protected boolean scrollUntilElementVisible(MobileElement container, List<MobileElement> elements, String expectedText) {
        for (int i = 0; i <= 4; i++) {
            MobileElement foundElement = elements.stream()
                    .filter(element -> element.getText().equals(expectedText))
                    .findFirst()
                    .orElse(null);

            if (foundElement != null) {
                return true;
            }

            scrollDown(container);
        }

        return false;
    }


    protected void scrollDown(MobileElement container) {
        Rectangle rect = container.getRect();
        int containerX = rect.getX() / 2;
        TouchAction action = new TouchAction(driver);
        PointOption initialPosition = PointOption.point(containerX, rect.getHeight());
        PointOption finalPosition = PointOption.point(containerX, rect.getY() / 2);

        action.longPress(initialPosition)
                .moveTo(finalPosition)
                .release()
                .perform();
    }

}
