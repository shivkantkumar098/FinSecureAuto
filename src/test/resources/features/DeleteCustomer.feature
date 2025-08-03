Feature: Delete customer

  Background:
#    Given I am logged in with valid credentials
    And user is on the Delete Customer Page

  Scenario: Successfully delete a customer
    When user enters the customer ID "27754"
    And user clicks on the "Submit" button
    Then user should see a confirmation message "Do you really want to delete this Customer?"
    When user confirms the deletion
    Then user should see a success message "You are not authorize to delete this customer!!"
#
  Scenario: Unsuccessful deletion due to non-existent customer ID
    When user enters the customer ID "99999"
    And user clicks on the "Submit" button
    Then user should see a confirmation message "Do you really want to delete this Customer?"
    When user confirms the deletion
    Then user should see an error message "Customer does not exist!!"
##
  Scenario: Unsuccessful deletion due to invalid customer ID format
    When user enters the customer ID "abcde"
    Then user should see an error message "Characters are not allowed"

  Scenario: Reset deletes customer ID input
    When user enters the customer ID "12345"
    And user clicks on the "Reset" button
    Then the customer ID input should be empty
