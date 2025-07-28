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
import org.openqa.selenium.WebDriver;
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
}
