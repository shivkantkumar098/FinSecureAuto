package org.finsecure.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.*;


import org.finsecure.constant.Credentials;
import org.finsecure.driver.singleton.DriverManager;
import org.finsecure.pages.LoginPage;
import org.finsecure.utils.PropertyUtils;
import org.finsecure.utils.WaitUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

@Epic("Login Feature")
@Feature("Valid Login")
public class LoginSteps {

    private final WebDriver driver = DriverManager.getDriver("chrome");
    private final LoginPage loginPage = new LoginPage(driver);

    @Severity(SeverityLevel.CRITICAL)
    @Description("User logs in with valid credentials")
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String baseUrl = PropertyUtils.get("base.url");
        driver.get(baseUrl);
        WaitUtils.waitForPageToLoad(driver, 10);
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        loginPage.enterUsername(Credentials.DEMO_USERNAME);
        loginPage.enterPassword(Credentials.DEMO_PASSWORD);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the homepage")
    public void i_should_be_redirected_to_the_homepage() {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed or homepage not loaded.");
    }

    @When("I enter invalid username and password")
    public void iEnterInvalidUsernameAndPassword() {
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPass");
        loginPage.clickLogin();
    }

    @Then("I should see an alert error message indicating invalid credentials")
    public void iShouldSeeAnAlertErrorMessageIndicatingInvalidCredentials() {
        String expectedErrorMessage = "User or Password is not valid";
        String actualErrorMessage = null;
        try {
            Alert alert = driver.switchTo().alert();
            actualErrorMessage = alert.getText();
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
            alert.accept();
        } catch (NoAlertPresentException e) {
            Assert.fail("Expected alert was not present.");
        }

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match expected.");
        driver.switchTo().alert().accept(); // Close the alert
    }
    @Then("I should see an alert error message indicating invalid credential")
    public void iShouldSeeAnAlertErrorMessageIndicatingInvalidCredential() {
        String expectedErrorMessage = "User or Password is not valid";
        String actualErrorMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match expected.");
        driver.switchTo().alert().accept(); // Close the alert
    }

    @When("I leave the username and password fields empty")
    public void iLeaveTheUsernameAndPasswordFieldsEmpty() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.enterUsername("");

    }

    @Then("I should see an error message indicating that fields cannot be empty")
    public void iShouldSeeAnErrorMessageIndicatingThatFieldsCannotBeEmpty() {
        By userErrorLocator = By.xpath("//label[.='User-ID must not be blank']");
        By passwordErrorLocator = By.id("message18");

        String expectedErrorMessageForUserName = "User-ID must not be blank";
        String expectedErrorMessageForPassword = "Password must not be blank";

        String actualErrorMessage = WaitUtils.waitForElementVisible(driver, userErrorLocator, 10).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessageForUserName, "Username error message does not match expected.");

        String actualErrorMessageForPassword = WaitUtils.waitForElementVisible(driver, passwordErrorLocator, 10).getText();
        Assert.assertEquals(actualErrorMessageForPassword, expectedErrorMessageForPassword, "Password error message does not match expected.");
    }

    @When("I enter a username with special characters")
    public void iEnterAUsernameWithSpecialCharacters() {
        loginPage.enterUsername("user@name!#");

    }

    @And("I enter a valid password")
    public void iEnterAValidPassword() {
        loginPage.enterPassword(Credentials.DEMO_PASSWORD);

    }

    @When("I enter a valid username")
    public void iEnterAValidUsername() {
        loginPage.enterUsername(Credentials.DEMO_USERNAME);
    }

    @And("I enter a password with special characters")
    public void iEnterAPasswordWithSpecialCharacters() {
        loginPage.enterPassword("pass@word#123");
    }


}
