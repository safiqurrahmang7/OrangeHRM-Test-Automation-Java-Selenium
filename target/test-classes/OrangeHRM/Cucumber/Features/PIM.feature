Feature: PIM Module in OrangeHRM

  Feature: Employee Management in PIM Module

  Background:
    Given I log in with "Admin" and "admin123"
    And I navigate to PIM module

  @LoginDetailsUntogggled @Regression
  Scenario: Create a new employee with login
    When I click on Add button
    And I enter "John" in the first name field
    And I enter "Doe" in the last name field
    And I click the save button
    Then I should see a confirmation message "Successfully Saved"

  
