package com.learnappium.stepdefs;

import com.learnappium.pageobject.LoginPage;
import com.learnappium.provider.UserProvider;
import com.learnappium.provider.models.User;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginSteps {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private UserProvider userProvider;

    @Given("that the user is authenticated")
    public void thatTheUserIsAuthenticated() {
        User user = userProvider.getUser("default");
        loginPage.loginWithEmail(user.getEmail(), user.getPassword());
    }

}
