package com.automation.pages;

import com.automation.utils.ConfigFileReaderUtils;
import com.automation.utils.DriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement userPasswordInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    public void openWebsite() {
        DriverUtils.getDriver().get(ConfigFileReaderUtils.getProperty("app.url"));
    }

    public void userEntersUserNameAndPassword() {
        userNameInput.sendKeys(ConfigFileReaderUtils.getProperty("app.username"));
        userPasswordInput.sendKeys(ConfigFileReaderUtils.getProperty("app.password"));
    }

    public void userClickOnSubmitButton() {
        submitButton.click();
    }

    public WebElement getUserNameInput() {
        return userNameInput;
    }

    public WebElement getPasswordInput() {
        return userPasswordInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }




}
