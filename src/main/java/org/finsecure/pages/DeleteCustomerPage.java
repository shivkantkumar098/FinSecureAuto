package org.finsecure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class DeleteCustomerPage extends BasePage {

    private final By customerIDInput = By.name("cusid");
    private final By submitBtn = By.name("AccSubmit");
    private final By resetBtn = By.name("res");

    private final By invalidCharacterError = By.xpath("//label[@id='message14']");
    public DeleteCustomerPage(WebDriver driver) {
        super(driver);
    }

    public void enterCustomerID(String customerID) {
        driver.findElement(customerIDInput).clear();
        driver.findElement(customerIDInput).sendKeys(customerID);
    }

    public void clickSubmitButton() {
        driver.findElement(submitBtn).click();
    }

    public void clickResetButton() {
        driver.findElement(resetBtn).click();
    }

    public String getCustomerIDValue() {
        return driver.findElement(customerIDInput).getAttribute("value");
    }

    public String getInvalidCharacterErrorMessage() {
        return driver.findElement(invalidCharacterError).getText();

    }
}
