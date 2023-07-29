package com.automation.steps;

import com.automation.pages.AccountTransactionPage;
import io.cucumber.java.en.Then;

public class TransactionSteps {

    AccountTransactionPage accountTransactionPage = new AccountTransactionPage();

    @Then("verify an account transaction page is displayed for user")
    public void verify_an_account_transaction_page_is_displayed_for_user() {
        accountTransactionPage.verifyTransactionPage();
    }

    @Then("verify transaction history is displayed for new transaction")
    public void verify_transaction_history_is_displayed_for_new_transaction() {
        accountTransactionPage.verifyTransactionHistory();
    }

    @Then("verify transaction is getting updated in database")
    public void verify_transaction_is_getting_updated_in_database() {
        accountTransactionPage.verifyTransactionInDatabase();
    }

}
