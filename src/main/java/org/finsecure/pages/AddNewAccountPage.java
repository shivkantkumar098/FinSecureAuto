package org.finsecure.pages;

import org.finsecure.constant.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddNewAccountPage extends BasePage {

    public AddNewAccountPage(WebDriver driver) {
        super(driver);
    }

    // Locators (Update IDs according to actual HTML if needed)
//    private final By accountTypeDropdown = By.id("accountType");
    private final By initialDepositField = By.name("inideposit");
    private final By submitButton = By.name("button2");
    private final By resetButton = By.name("reset");
    private final By successMessage = By.id("successMessage"); // You may need to update this
    private final By errorMessage = By.id("message19");
    private final By customerIdInputBox=By.name("cusid");
    private final By accountTypeDropdownLocator = By.name("selaccount");

    public void navigateToAddNewAccountPage() {
        driver.get(Credentials.AddNewAccount_URL);
    }

    public void enterCustomerId(String customerId) {
        try {
            WebElement input = driver.findElement(customerIdInputBox);
            input.clear();
            input.sendKeys(customerId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter customer ID: " + customerId, e);
        }
    }
    public void selectAccountType(String accountType) {
        Select select=new Select(driver.findElement(accountTypeDropdownLocator));
        select.selectByContainsVisibleText(accountType);
    }


    public void enterInitialDeposit(String initialDeposit) {
        try {
            WebElement input = driver.findElement(initialDepositField);
            input.clear();
            input.sendKeys(initialDeposit);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter initial deposit: " + initialDeposit, e);
        }
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void clickReset() {
        driver.findElement(resetButton).click();
    }

    public String getSuccessMessage() {
        try {
            return driver.findElement(successMessage).getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getSelectedAccountType() {
        try {
            return driver.findElement(accountTypeDropdownLocator).getAttribute("value");
        } catch (Exception e) {
            return null;
        }
    }

    public String getInitialDepositValue() {
        try {
            return driver.findElement(initialDepositField).getAttribute("value");
        } catch (Exception e) {
            return null;
        }
    }

    public String getCustomerIdValue() {
        try {
            return driver.findElement(customerIdInputBox).getAttribute("value");
        } catch (Exception e) {
            return null;
        }
    }
}
