package com.learnappium.hooks;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class TeardownHook {

    @Autowired
    MobileDriver<MobileElement> driver;

    @Before
    public void before() {
        driver.resetApp();
    }
}
