#Feature: Customer Registration Form
#
#  Background:
#    Given I am on the login page
#    When I enter valid username and password
#    And I click on the login button
#    Then I should be redirected to the homepage
#
#  Scenario Outline: Register customer with valid mandatory fields and validate registration
#    Given I am on the customer registration page
#    When I fill in the customer form with
#      | Customer Name   | <name>       |
#      | Gender          | <gender>     |
#      | DOB             | <dob>        |
#      | Address         | <address>    |
#      | City            | <city>       |
#      | State           | <state>      |
#      | PIN             | <pin>        |
#      | Telephone       | <telephone>  |
#      | Email           | <email>      |
#      | Password        | <password>   |
#    And I submit the form
#    Then I should see a confirmation message that the customer has been registered successfully
#    Examples:
#      | name   | gender | dob        | address            | city      | state     | pin    | telephone  | email                     | password  |
#      | Ananya | female | 12/15/1992 | 89 Lotus Enclave   | Ranchi    | Jharkhand | 834001 | 9123456789 | ana337373nya@mailtest.com | an@123abc |
#      | Rohan  | male   | 03/05/1988 | 301 Sunrise Towers | Bhagalpur | Bihar     | 812001 | 9988776655 | rohan34989058054@demo.com | ro#456xyz |
