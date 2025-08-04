package org.finsecure.stepdefinitions;

import io.cucumber.java.en.*;
import org.finsecure.constant.Credentials;
import org.finsecure.driver.singleton.DriverManager;
import org.finsecure.pages.DeleteCustomerPage;
import org.finsecure.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DeleteCustomer {

    private final WebDriver driver = DriverManager.getDriver("chrome");
    private final LoginPage loginPage = new LoginPage(driver);
    private final DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage(driver);

//    @Given("I am logged in with valid credentials")
    public void iAmLoggedInWithValidCredentials() {
        driver.get(Credentials.BASE_URL);
        loginPage.enterUsername(Credentials.DEMO_USERNAME);
        loginPage.enterPassword(Credentials.DEMO_PASSWORD);
        loginPage.clickLogin();
    }

    @Given("user is on the Delete Customer Page")
    public void userIsOnTheDeleteCustomerPage() {
        driver.get(Credentials.DeleteCustomer_URL);
    }

    @When("user enters the customer ID {string}")
    public void userEntersTheCustomerID(String customerID) {
        deleteCustomerPage.enterCustomerID(customerID);
    }

    @And("user clicks on the {string} button")
    public void userClicksOnTheButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("submit")) {
            deleteCustomerPage.clickSubmitButton();
        } else if (buttonName.equalsIgnoreCase("reset")) {
            deleteCustomerPage.clickResetButton();
        } else {
            throw new IllegalArgumentException("Invalid button name: " + buttonName);
        }
    }

    @Then("user should see a confirmation message {string}")
    public void userShouldSeeAConfirmationMessage(String alertMsg) {
        Alert alert = waitForAlert(5);
        String actualAlertMessage = alert.getText();
        Assert.assertEquals(actualAlertMessage, alertMsg, "Alert message does not match expected value.");
    }

    @When("user confirms the deletion")
    public void userConfirmsTheDeletion() {
        Alert alert = waitForAlert(5);
        alert.accept();
    }

    @Then("user should see a success message {string}")
    public void userShouldSeeASuccessMessage(String successMsg) {
        Alert alert = waitForAlert(5);
        String actualSuccessMessage = alert.getText();
        Assert.assertEquals(actualSuccessMessage, successMsg, "Success message does not match expected value.");
        alert.accept();
    }

    @Then("user should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String errorMsg) {
        Alert alert = waitForAlert(5);
        String actualErrorMsg = alert.getText();
        Assert.assertEquals(actualErrorMsg, errorMsg, "Error message does not match expected value");
    }

    @Then("the customer ID input should be empty")
    public void customerIDShouldBeEmpty() {
        String actual = deleteCustomerPage.getCustomerIDValue();
        Assert.assertEquals(actual, "", "Customer ID input is not cleared after reset");
    }

    private Alert waitForAlert(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("user should see an error message that {string}")
    public void userShouldSeeAnErrorMessageThat(String invalidErrorMsg) {
        String actualErrorMessage = deleteCustomerPage.getInvalidCharacterErrorMessage();
        Assert.assertEquals(actualErrorMessage, invalidErrorMsg, "Invalid character error message does not match expected value.");
    }
}
