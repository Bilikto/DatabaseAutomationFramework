package com.automation.pages;

import com.automation.utils.ConfigFileReaderUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WithdrawPage extends BasePage {

    @FindBy(id="selectedAccount")
    WebElement withdrawDropdown;

    @FindBy(id= "amount")
    WebElement withdrawAmountInput;

    @FindBy(xpath="//div[@class='card-footer']/button[@type='submit']")
    WebElement submitButton;

    public void verifyWithdrawPage() {
        Assert.assertTrue(withdrawDropdown.isDisplayed());
    }

    public void selectWithdrawAccount() {
        Select select = new Select(withdrawDropdown);
        select.selectByVisibleText("TestChecking (Standard Checking)");
    }

    public void enterWithdrawAmount() {
        withdrawAmountInput.sendKeys(ConfigFileReaderUtils.getProperty("app.amount"));
    }

    public void userClickOnSubmitButton() { submitButton.click(); }

    public WebElement getWithdrawDropdown() {
        return withdrawDropdown;
    }

    public WebElement getWithdrawAmountInput() { return withdrawAmountInput; }

    public WebElement getSubmitButton() {
        return submitButton;
    }

}
