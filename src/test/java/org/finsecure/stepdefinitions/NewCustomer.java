package org.finsecure.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.finsecure.constant.Credentials;
import org.finsecure.driver.singleton.DriverManager;
import org.finsecure.pages.LoginPage;
import org.finsecure.pages.NewCustomerPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class NewCustomer {
    private final WebDriver driver = DriverManager.getDriver("chrome");
    private final LoginPage loginPage = new LoginPage(driver);
    private final NewCustomerPage customerPage = new NewCustomerPage(driver);

    @Given("I am logged in with valid credentials")
    public void iAmLoggedInWithValidCredentials() {
        driver.get(Credentials.BASE_URL);
        loginPage.enterUsername(Credentials.DEMO_USERNAME);
        loginPage.enterPassword(Credentials.DEMO_PASSWORD);
        loginPage.clickLogin();
    }

    @Given("I am on the customer registration page")
    public void iAmOnTheCustomerRegistrationPage() {
        loginPage.navigateToNewCustomerPage();
    }

    @When("I fill in the customer form with")
    public void i_fill_in_the_customer_form_with(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        customerPage.enterCustomerName(data.get("Customer Name"));
        customerPage.selectGender(data.get("Gender"));
        customerPage.enterDOB(data.get("DOB"));
        customerPage.enterAddress(data.get("Address"));
        customerPage.enterCity(data.get("City"));
        customerPage.enterState(data.get("State"));
        customerPage.enterPIN(data.get("PIN"));
        customerPage.enterTelephone(data.get("Telephone"));
        customerPage.enterEmail(data.get("Email"));
        customerPage.enterPassword(data.get("Password"));
    }

    @And("I submit the form")
    public void i_submit_the_form() {
        customerPage.submitForm();
    }

    @Then("I should see a confirmation message that the customer has been registered successfully")
    public void i_should_see_confirmation_message() {
        Assert.assertTrue(customerPage.isConfirmationDisplayed(), "Confirmation message not found");
    }

}
