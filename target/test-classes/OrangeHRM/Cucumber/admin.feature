
@AdminCreation
Feature: Creating the admin user

	Background: 
	Given Launch the application
	
  @admin @Smoke @Regression
  Scenario Outline: create admin user with user creds
    Given Login the application with username "Admin" and password "admin123"
    When create the employee "<username>" without the username
    And create the Admin with username "<username>"
    Then Toaster Message should be displayed as "Successfully Saved"

    Examples: 
      | username  				 |
      | John Michael Smith |
