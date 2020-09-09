package com.learnappium.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@ComponentScan(basePackages = {"com.learnappium.pageobject.impl.ios", "com.learnappium.pageobject.impl.common"})
@Profile("ios")
public class iOSTestConfig {

    @Bean
    public AppiumDriver<MobileElement> mobileDriver() throws MalformedURLException {
        return new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), getCapabilities());
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        return capabilities;
    }

}
