package org.finsecure.stepdefinitions;

import io.cucumber.java.en.*;
import org.finsecure.constant.Credentials;
import org.finsecure.driver.singleton.DriverManager;
import org.finsecure.pages.ChangePasswordPage;
import org.finsecure.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import pages.ChangePasswordPage;

public class ChangePasswordSteps {

    private final WebDriver driver = DriverManager.getDriver("chrome");
    private final LoginPage loginPage = new LoginPage(driver);
    private final ChangePasswordPage changePasswordPage=new ChangePasswordPage(driver);

    public void iAmLoggedInWithValidCredentials() {
        driver.get(Credentials.BASE_URL);
        loginPage.enterUsername(Credentials.DEMO_USERNAME);
        loginPage.enterPassword(Credentials.DEMO_PASSWORD);
        loginPage.clickLogin();

    }
    @Given("I navigate to the Change Password page")
    public void navigate_to_change_password() {

        changePasswordPage.navigateToChangePasswordPage();
    }

    @When("I leave Old Password field blank")
    public void leave_old_password_blank() {
        changePasswordPage.enterOldPassword("");
    }

    @When("I enter old password {string}")
    public void enter_old_password(String oldPass) {
        changePasswordPage.enterOldPassword(oldPass);
    }

    @And("I enter new password {string}")
    public void enter_new_password(String newPass) {
        changePasswordPage.enterNewPassword(newPass);
    }

    @And("I enter confirm password {string}")
    public void enter_confirm_password(String confirmPass) {
        changePasswordPage.enterConfirmPassword(confirmPass);
    }

    @And("I submit the Change Password form")
    public void submit_change_password_form() {
        changePasswordPage.submitForm();
    }

    @Then("I should see an error message {string}")
    public void verify_error_message(String expectedMessage) {
        String actualMsg = changePasswordPage.getErrorMessage();
        Assert.assertTrue(actualMsg.contains(expectedMessage),
                "Expected error: " + expectedMessage + " but got: " + actualMsg);
        driver.quit();
    }

    @Then("I should see an special an message {string}")
    public void iShouldSeeAnSpecialCharErrorMessage(String specaialCharError) {
        String actualMsg = changePasswordPage.getSpecialCharError();
        Assert.assertTrue(actualMsg.contains(specaialCharError),
                "Expected error: " + specaialCharError + " but got: " + actualMsg);
        driver.quit();
    }

    @Then("I should see an password error message {string}")
    public void iShouldSeeAnPasswordErrorMessage(String passwordError) {
        String actualMsg = changePasswordPage.getPasswordError();
        Assert.assertTrue(actualMsg.contains(passwordError),
                "Expected error: " + passwordError + " but got: " + actualMsg);
        driver.quit();
    }
}
