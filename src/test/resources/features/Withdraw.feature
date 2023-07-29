Feature: Transaction validation

  @Regression
  Scenario: Verify user can transfer the fund
    Given user open website
    When user is entering valid username "username" and valid password "password"
    And user click on sign in button
    Then verify a homepage is displayed to user

    When user click on withdraw menu
    Then verify a withdraw page is displayed for user

    When user selects account for withdraw "TestChecking (Standard Checking)"
    And user enter withdraw amount
    And user click submit button
    Then verify an account transaction page is displayed for user
    And verify transaction history is displayed for new transaction
    And verify transaction is getting updated in database













