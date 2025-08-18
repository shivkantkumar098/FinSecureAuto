package org.finsecure.pages;

import org.finsecure.constant.Credentials;
import org.finsecure.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends BasePage {

//    WebDriver driver;

    // Locators
    private By oldPasswordField = By.name("oldpassword");
    private By newPasswordField = By.name("newpassword");
    private By confirmPasswordField = By.name("confirmpassword");
    private By submitBtn = By.name("sub");
    private By errorMessage = By.id("message20"); // Adjust locator as per UI
    private By specialCharError = By.id("message21"); // Adjust locator as per UI
    private By passowrdError = By.id("message22"); // Adjust locator as per UI

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToChangePasswordPage() {
        driver.get(Credentials.ChangePassword_URL);
    }
    // Actions
    public void enterOldPassword(String oldPass) {
        driver.findElement(oldPasswordField).clear();
        driver.findElement(oldPasswordField).sendKeys(oldPass);
    }

    public void enterNewPassword(String newPass) {
        driver.findElement(newPasswordField).clear();
        driver.findElement(newPasswordField).sendKeys(newPass);
    }

    public void enterConfirmPassword(String confirmPass) {
        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(confirmPass);
    }

    public void submitForm() {
        driver.findElement(submitBtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }


    public String getSpecialCharError() {
        return driver.findElement(specialCharError).getText();
    }

    public String getPasswordError() {
        return driver.findElement(passowrdError).getText();
    }
}
