package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Then("verify a homepage is displayed to user")
    public void verify_a_homepage_is_displayed_to_user() {
        homePage.verifyHomePage();
    }

    @When("user click on withdraw menu")
    public void user_click_on_withdraw_menu() {
        homePage.clickWithdrawMenuButton();
    }

}
