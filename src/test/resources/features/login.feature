#This file contains the feature definition for the login functionality
Feature: Login functionality
  Background:
    Given I am on the login page
  Scenario: Successful login with valid credentials
    When I enter valid username and password
    And I click on the login button
    Then I should be redirected to the homepage
   Scenario: Unsuccessful login with empty username and password
        When I leave the username and password fields empty
        Then I should see an error message indicating that fields cannot be empty
    Scenario: Unsuccessful login with special characters in username
        When I enter a username with special characters
        And I enter a valid password
        And I click on the login button
        Then I should see an alert error message indicating invalid credential

    Scenario: Unsuccessful login with special characters in password
        When I enter a valid username
        And I enter a password with special characters
        And I click on the login button
        Then I should see an alert error message indicating invalid credentials
