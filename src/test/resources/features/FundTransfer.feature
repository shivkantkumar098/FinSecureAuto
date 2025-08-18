Feature: Fund Transfer
  As a user
  I want to transfer funds between accounts
  So that the transaction is completed securely and correctly

  Background:
    Given I navigate to the Fund Transfer page

  @Positive
  Scenario: Successful fund transfer
    When I enter Payers Account Number "10101"
    And I enter Payees Account Number "20202"
    And I enter Amount "5000"
    And I enter Description "Monthly Rent"


  @Negative
  Scenario: Payees Account Number must not be blank
    When I leave Payees Account Number field blank
    Then I should see an payees error message "Payees Account Number must not be blank"
#
  @Negative
  Scenario: Payers Account Number must not be blank
    When I leave Payers Account Number field blank
    Then I should see an payers error message "Payers Account Number must not be blank"

  @Negative
  Scenario: Payers Account Number cannot contain characters
    When I enter Payers Account Number "a123"
    Then I should see an  character error message "Characters are not allowed"

  @Negative
  Scenario: Amount must not be blank
    When I leave Amount field blank
    Then I should see an amount error message "Amount field must not be blank"

  @Negative
  Scenario: Amount cannot contain characters
    When I enter Amount "abc"
    Then I should see an AmountCharacter error message "Characters are not allowed"

  @Negative
  Scenario: Description must not be blank
    When I leave Description field blank
    Then I should see an Description error message "Description can not be blank"
