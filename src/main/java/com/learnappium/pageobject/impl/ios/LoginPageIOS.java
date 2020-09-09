package com.learnappium.pageobject.impl.ios;

import com.learnappium.pageobject.LoginPage;
import org.springframework.stereotype.Component;

@Component
public class LoginPageIOS implements LoginPage {
    public void loginWithEmail(String email, String password) {
        System.out.println("Hello LoginPageIOS");
    }
}
