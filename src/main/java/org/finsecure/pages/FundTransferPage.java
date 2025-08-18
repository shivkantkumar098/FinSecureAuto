package org.finsecure.pages;

import org.finsecure.constant.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTransferPage extends BasePage {
    public FundTransferPage(WebDriver driver) {
        super(driver);
    }

    // Locators (adjust IDs/XPaths as per your actual HTML)
    private final By payersAccountInput = By.name("payersaccount");
    private final By payeesAccountInput = By.name("payeeaccount");
    private final By amountInput = By.name("ammount");
    private final By descriptionInput = By.name("desc");
    private final By submitButton = By.name("AccSubmit");

    private final By successMessage = By.id("successMsg");
    private final By payeeErrorMessage = By.id("message11");
    private final By payerErrorMsg = By.id("message10");
    private final By characterErrorMessage = By.id("message10");
    private final By amountCharacterErrorMsg = By.id("message1");
    private final By amountErrorMsg = By.id("message1");
    private final By descErrorMsg = By.id("message17");


    public void navigateToFundTransferPage() {
        driver.get(Credentials.FundTransfer_URL);
    }
    public void enterPayersAccount(String payersAcc) {
        driver.findElement(payersAccountInput).clear();
        driver.findElement(payersAccountInput).sendKeys(payersAcc);
    }

    public void enterPayeesAccount(String payeesAcc) {
        driver.findElement(payeesAccountInput).clear();
        driver.findElement(payeesAccountInput).sendKeys(payeesAcc);
    }

    public void enterAmount(String amt) {
        driver.findElement(amountInput).clear();
        driver.findElement(amountInput).sendKeys(amt);
    }

    public void enterDescription(String desc) {
        driver.findElement(descriptionInput).clear();
        driver.findElement(descriptionInput).sendKeys(desc);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

//    public String getErrorMessage() {
//        return driver.findElement(errorMessage).getText();
//    }

    public void clearPayersAccount() {
        driver.findElement(payersAccountInput).sendKeys("23");
        driver.findElement(payersAccountInput).clear();
    }

    public void clearPayeesAccount() {
        driver.findElement(payeesAccountInput).sendKeys("23");
        driver.findElement(payeesAccountInput).clear();
    }

    public void clearAmount() {
        driver.findElement(amountInput).sendKeys("sd");
        driver.findElement(amountInput).clear();
    }

    public void clearDescription() {
        driver.findElement(descriptionInput).sendKeys("df");
        driver.findElement(descriptionInput).clear();
    }


    public String getPayeeErrorMessage() {
        return driver.findElement(payeeErrorMessage).getText();
    }

    public String getPayerErrorMessage() {
        return driver.findElement(payerErrorMsg).getText();
    }

    public String getCharcterErrorMessage() {
        return driver.findElement(characterErrorMessage).getText();
    }

    public String getAmountCharacterErrorMessage() {
        return driver.findElement(amountCharacterErrorMsg).getText();
    }

    public String getAmountErrorMessage() {
        return driver.findElement(amountErrorMsg).getText();
    }

    public String getDescErrorMessage() {
        return driver.findElement(descErrorMsg).getText();

    }
}
