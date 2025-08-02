package org.finsecure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage extends BasePage {

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    private final By customerName = By.name("name");
    private final By maleRadio = By.xpath("//input[@value='m']");
    private final By femaleRadio = By.xpath("//input[@value='f']");
    private final By dob = By.name("dob");
    private final By address = By.name("addr");
    private final By city = By.name("city");
    private final By state = By.name("state");
    private final By pin = By.name("pinno");
    private final By telephone = By.name("telephoneno");
    private final By email = By.name("emailid");
    private final By password = By.name("password");
    private final By submitBtn = By.name("sub");

    public void enterCustomerName(String name) {
        driver.findElement(customerName).sendKeys(name);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(maleRadio).click();
        } else {
            driver.findElement(femaleRadio).click();
        }
    }

    public void enterDOB(String date) {
        driver.findElement(dob).sendKeys(date);
    }

    public void enterAddress(String value) {
        driver.findElement(address).sendKeys(value);
    }

    public void enterCity(String value) {
        driver.findElement(city).sendKeys(value);
    }

    public void enterState(String value) {
        driver.findElement(state).sendKeys(value);
    }

    public void enterPIN(String value) {
        driver.findElement(pin).sendKeys(value);
    }

    public void enterTelephone(String value) {
        driver.findElement(telephone).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(email).sendKeys(value);
    }
    public void enterPassword(String value) {
        // Assuming the password field is the same as email for this form
        driver.findElement(password).sendKeys(value);
    }

    public void submitForm() {
        driver.findElement(submitBtn).click();
    }

    public boolean isConfirmationDisplayed() {
        return driver.getPageSource().contains("Customer Registered Successfully");
    }

}

