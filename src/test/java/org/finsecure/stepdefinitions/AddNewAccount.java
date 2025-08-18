package org.finsecure.stepdefinitions;

import io.cucumber.java.en.*;
import org.finsecure.constant.Credentials;
import org.finsecure.driver.singleton.DriverManager;
import org.finsecure.pages.AddNewAccountPage;
import org.finsecure.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class AddNewAccount {
    private final WebDriver driver = DriverManager.getDriver("chrome");
    private final LoginPage loginPage = new LoginPage(driver);
    private final AddNewAccountPage addNewAccountPage = new AddNewAccountPage(driver);


    public void iAmLoggedInWithValidCredentials() {
        driver.get(Credentials.BASE_URL);
        loginPage.enterUsername(Credentials.DEMO_USERNAME);
        loginPage.enterPassword(Credentials.DEMO_PASSWORD);
        loginPage.clickLogin();
    }

    @Given("user is on the Add New Account Page")
    public void userIsOnTheAddNewAccountPage() {
        addNewAccountPage.navigateToAddNewAccountPage();
    }

    @When("user enters {string} as customer ID")
    public void userEntersAsCustomerID(String customerId) {
        addNewAccountPage.enterCustomerId(customerId);
    }
    @And("user selects {string} as the account type")
    public void userSelectsAsTheAccountType(String accountType) {
        addNewAccountPage.selectAccountType(accountType);
    }
    @And("user enters an initial deposit of {string}")
    public void userEntersAnInitialDepositOf(String initialDeposit) {
        addNewAccountPage.enterInitialDeposit(initialDeposit);
    }

    @And("user clicks on {string} button")
    public void userClicksOnTheButton(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "submit":
                addNewAccountPage.clickSubmit();
                break;
            case "reset":
                addNewAccountPage.clickReset();
                break;
            default:
                throw new IllegalArgumentException("Unknown button: " + buttonName);
        }
    }

    @Then("user should see an initial Deposit message {string}")
    public void userShouldSeeAnInitialDepositMessage(String expectedMessage) {
        String actualMessage = addNewAccountPage.getErrorMessage();
        if (!expectedMessage.equals(actualMessage)) {
            throw new AssertionError("Expected: " + expectedMessage + ", but got: " + actualMessage);
        }
    }
    @Then("the customer id should be empty")
    public void theCustomerIdShouldBeEmpty() {
        String customerIdValue = addNewAccountPage.getCustomerIdValue();
        if (customerIdValue != null && !customerIdValue.isEmpty()) {
            throw new AssertionError("Customer ID input is not empty. Current value: " + customerIdValue);
        }
    }

    @And("the initial deposit input should be empty")
    public void theInitialDepositInputShouldBeEmpty() {
        String initialDepositValue = addNewAccountPage.getInitialDepositValue();
        if (initialDepositValue != null && !initialDepositValue.isEmpty()) {
            throw new AssertionError("Initial deposit input is not empty. Current value: " + initialDepositValue);
        }
    }


}
