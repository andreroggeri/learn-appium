package com.learnappium.pageobject.impl.android;

import com.learnappium.pageobject.LoginPage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class LoginPageAndroid implements LoginPage {

    @FindBy(id = "email_button")
    private MobileElement emailButton;

    @FindBy(id = "email")
    private MobileElement emailInput;

    @FindBy(id = "password")
    private MobileElement passwordInput;

    @FindBy(id = "button_next")
    private MobileElement nextButton;

    @FindBy(id = "button_done")
    private MobileElement signinButton;

    private AndroidDriver<MobileElement> driver;

    public LoginPageAndroid(MobileDriver<MobileElement> driver) {
        this.driver = (AndroidDriver<MobileElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void loginWithEmail(String email, String password) {
        emailButton.click();
        emailInput.sendKeys(email);
        nextButton.click();
        passwordInput.sendKeys(password);
        signinButton.click();
    }

}
