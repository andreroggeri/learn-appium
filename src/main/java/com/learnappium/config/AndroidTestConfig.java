package com.learnappium.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = {"com.learnappium.pageobject.impl.android", "com.learnappium.pageobject.impl.common"})
@Profile("android")
public class AndroidTestConfig {

    @Bean
    public AppiumDriver<MobileElement> appiumDriver() throws MalformedURLException {
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), getCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.APP, getAppPath());
        capabilities.setCapability("appWaitActivity", "com.firebase.ui.auth.ui.idp.AuthMethodPickerActivity");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_API_28");
        return capabilities;
    }

    private String getAppPath() {
        URL app = getClass().getClassLoader().getResource("app-debug.apk");
        try {
            File file = new File(app.toURI());
            return file.getPath();
        } catch (URISyntaxException ex) {
            throw new RuntimeException("Error loading APK", ex);
        }

    }
}
