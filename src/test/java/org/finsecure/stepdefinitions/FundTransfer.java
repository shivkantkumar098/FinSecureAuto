package org.finsecure.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.finsecure.constant.Credentials;
import org.finsecure.driver.singleton.DriverManager;
import org.finsecure.pages.FundTransferPage;
import org.finsecure.pages.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FundTransfer {
    private final WebDriver driver= DriverManager.getDriver("chrome");
    private final LoginPage loginPage=new LoginPage(driver);
    private final FundTransferPage fundTransferPage=new FundTransferPage(driver);

    public void iAmLoggedInWithValidCredentials() {
        driver.get(Credentials.BASE_URL);
        loginPage.enterUsername(Credentials.DEMO_USERNAME);
        loginPage.enterPassword(Credentials.DEMO_PASSWORD);
        loginPage.clickLogin();
    }
    @Given("I navigate to the Fund Transfer page")
    public void navigateToFundTransferPage() {
        fundTransferPage.navigateToFundTransferPage();
    }

    @When("I enter Payers Account Number {string}")
    public void iEnterPayersAccountNumber(String accountNo) {
        fundTransferPage.enterPayersAccount(accountNo);
    }

    @And("I enter Payees Account Number {string}")
    public void iEnterPayeesAccountNumber(String arg0) {
        fundTransferPage.enterPayeesAccount(arg0);
    }

    @And("I enter Amount {string}")
    public void iEnterAmount(String arg0) {
        fundTransferPage.enterAmount(arg0);
    }

    @And("I enter Description {string}")
    public void iEnterDescription(String arg0) {
        fundTransferPage.enterDescription(arg0);
    }

    @And("I click on Submit")
    public void iClickOnSubmit() {
        fundTransferPage.clickSubmit();
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String expected) {
        String actual = fundTransferPage.getSuccessMessage();
        assert actual.equals(expected) : "Expected: " + expected + ", but got: " + actual;
    }

    @And("I leave Payees Account Number field blank")
    public void iLeavePayeesAccountNumberFieldBlank() {
        fundTransferPage.clearPayeesAccount();
    }

    @Then("I should see an payees error message {string}")
    public void iShouldSeeAnPayeesErrorMessage(String expected) {
        String actual = fundTransferPage.getPayeeErrorMessage();
        assert actual.equals(expected);
    }

    @When("I leave Payers Account Number field blank")
    public void iLeavePayersAccountNumberFieldBlank() {

        fundTransferPage.clearPayersAccount();
    }

    @Then("I should see an payers error message {string}")
    public void iShouldSeeAnPayersErrorMessage(String expected) {
        String actual = fundTransferPage.getPayerErrorMessage();
        assert actual.equals(expected);
    }

    @Then("I should see an  character error message {string}")
    public void iShouldSeeAnCharacterErrorMessage(String expected) {
        String actual = fundTransferPage.getCharcterErrorMessage();
        assert actual.equals(expected);
    }

    @And("I leave Amount field blank")
    public void iLeaveAmountFieldBlank() {

        fundTransferPage.clearAmount();
    }

    @Then("I should see an amount error message {string}")
    public void iShouldSeeAnAmountErrorMessage(String expected) {
        String actual = fundTransferPage.getAmountErrorMessage();
        assert actual.equals(expected);
    }

    @Then("I should see an AmountCharacter error message {string}")
    public void iShouldSeeAnAmountCharacterErrorMessage(String expected) {
        String actual = fundTransferPage.getAmountCharacterErrorMessage();
        assert actual.equals(expected);
    }

    @And("I leave Description field blank")
    public void iLeaveDescriptionFieldBlank() {
        fundTransferPage.clearDescription();
    }

    @Then("I should see an Description error message {string}")
    public void iShouldSeeAnDescribitionErrorMessage(String expected) {
        String actual = fundTransferPage.getDescErrorMessage();
        assert actual.equals(expected);
    }

//    @And("I move to next field")
//    public void iMoveToNextField() {
//        WebElement activeElement = driver.switchTo().activeElement();
//        activeElement.sendKeys(Keys.TAB);
//    }
}
