package com.automation.steps;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user open website")
    public void user_open_website() {
        loginPage.openWebsite();
    }

    @When("user is entering valid username {string} and valid password {string}")
    public void user_is_entering_valid_username_and_valid_password(String userName, String password) {
        loginPage.userEntersUserNameAndPassword();
    }

    @When("user click on sign in button")
    public void user_click_on_sign_in_button() {
        loginPage.userClickOnSubmitButton();
    }





}
