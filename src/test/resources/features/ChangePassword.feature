#Feature: Change Password functionality
#
#  As a registered user
#  I want to change my password
#  So that I can secure my account
#
#  Background:
#
#    Given I navigate to the Change Password page
#
#  Scenario: Old Password must not be blank
#    When I leave Old Password field blank
#    And I enter new password "Test@123"
#    And I enter confirm password "Test@123"
#    Then I should see an error message "Old Password must not be blank"


#  Scenario: New password without special character
#    When I enter old password "OldPass@1"
#    And I enter new password "Test1234"
#    And I enter confirm password "Test1234"
#    Then I should see an special an message "Enter at-least one special character"
##
#  Scenario: New password without numeric value
#    When I enter old password "OldPass@1"
#    And I enter new password "Test@Pass"
#    And I enter confirm password "Test@Pass"
#    Then I should see an special an message "Enter at-least one numeric value"
#
#  Scenario: Passwords do not match
#    When I enter old password "OldPass@1"
#    And I enter new password "Test@123"
#    And I enter confirm password "Test@321"
#    Then I should see an password error message "Passwords do not Match"
