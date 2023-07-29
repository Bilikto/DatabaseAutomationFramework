package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id="withdraw-menu-item")
    WebElement withdrawMenu;

    public void verifyHomePage() {
        Assert.assertTrue(withdrawMenu.isDisplayed());
    }

    public void clickWithdrawMenuButton() {
        withdrawMenu.click();
    }
}
