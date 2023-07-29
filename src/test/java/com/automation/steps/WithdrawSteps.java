package com.automation.steps;

import com.automation.pages.WithdrawPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WithdrawSteps {

    WithdrawPage withdrawPage = new WithdrawPage();

    @Then("verify a withdraw page is displayed for user")
    public void verify_a_withdraw_page_is_displayed_for_user() {
        withdrawPage.verifyWithdrawPage();
    }

    @When("user selects account for withdraw {string}")
    public void user_selects_account_for_withdraw(String string) {
        withdrawPage.selectWithdrawAccount();
    }

    @When("user enter withdraw amount")
    public void user_enter_withdraw_amount() {
        withdrawPage.enterWithdrawAmount();
    }

    @When("user click submit button")
    public void user_click_submit_button() {
        withdrawPage.userClickOnSubmitButton();
    }
}
