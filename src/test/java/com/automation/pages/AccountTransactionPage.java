package com.automation.pages;

import com.automation.utils.ConfigFileReaderUtils;
import com.automation.utils.DatabaseUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.ResultSet;

public class AccountTransactionPage extends BasePage {

    @FindBy(id="transactionTable_wrapper")
    WebElement transactionTable;

    @FindBy(xpath="//table[@id='transactionTable']/tbody/tr[1]/td[4]")
    WebElement transactionAmount;

    @FindBy(xpath="//table[@id='transactionTable']/tbody/tr[1]/td[3]")
    WebElement transactionDescription;

    private static String actualAmountFromUI;

    public void verifyTransactionPage() {
        Assert.assertTrue(transactionTable.isDisplayed());
    }

    public void verifyTransactionHistory() {
        String expectedAmount = ConfigFileReaderUtils.getProperty("app.amount");
        actualAmountFromUI = transactionAmount.getText().replace("$-", "").replace(".00", "");

        Assert.assertEquals("UI amounts are not matching", expectedAmount, actualAmountFromUI);

        System.out.println("Expected amount " +expectedAmount);
        System.out.println("Actual amount " + actualAmountFromUI);
    }

    public void verifyTransactionInDatabase() {
        try {
            //1. Get transaction number from UI (not from DB)
            String transactionDesc = transactionDescription.getText().replace(" (WTH) - Online Withdrawl", "");
            String query = ConfigFileReaderUtils.getProperty("db.query") + "\'" +transactionDesc+"\'";

            //2. Execute Query
            ResultSet rs = DatabaseUtils.executeQuery(query);
            rs.next();

            //3. Testing AmountFromCode and DB
            String expectedAmountFromCode = ConfigFileReaderUtils.getProperty("app.amount");
            String actualAmountFromDatabase = rs.getString("amount").replace("-", "").replace(".00", "");
            Assert.assertEquals("Mismatch amount between Code and Database", expectedAmountFromCode, actualAmountFromDatabase);

            //4. Testing of UI and DB
            String expectedAmountFromUI = actualAmountFromUI;
            Assert.assertEquals("Mismatch amount between UI and Database", expectedAmountFromUI, actualAmountFromDatabase);

            System.out.println("======== DB Testing ========");
            System.out.println("Expected amount from Code " + expectedAmountFromCode);
            System.out.println("Actual amount from UI " + actualAmountFromUI);
            System.out.println("Actual amount from DB " + actualAmountFromDatabase);
            System.out.println("Transaction decription # " + transactionDesc);

        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

}
