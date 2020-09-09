package com.learnappium;

import com.learnappium.config.AndroidTestConfig;
import com.learnappium.config.SharedConfig;
import com.learnappium.config.iOSTestConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = {AndroidTestConfig.class, iOSTestConfig.class, SharedConfig.class})
public class ContextConfig {
}
