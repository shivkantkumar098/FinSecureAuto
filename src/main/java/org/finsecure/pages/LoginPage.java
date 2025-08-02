package org.finsecure.pages;

import org.finsecure.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// org.openqa.selenium.support.PageFactory;
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "uid")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        return getTitle().contains("Guru99 Bank Manager HomePage");
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            // If we can switch to the alert, it means it is present

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void navigateToNewCustomerPage() {
        driver.findElement(By.linkText("New Customer")).click();
    }
}
