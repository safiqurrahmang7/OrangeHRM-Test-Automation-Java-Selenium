package OrangeHRM.Cucumber.StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import OrangeHRM.PageObjects.LoginPage;
import OrangeHRM.PageObjects.PIMPage;
import OrangeHRM.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMSteps extends BaseTest {
    
    LoginPage loginPage = Hooks.loginPage;
    PIMPage pimPage;
    
   
    
    @Given("I log in with {string} and {string}")
    public void i_log_in_with_and(String username, String password) throws IOException {
        
        loginPage.LoginApplication(username, password);
    }

    @Given("I navigate to PIM module")
    public void i_navigate_to_module() {
    	pimPage =  loginPage.goTo("PIM", PIMPage.class);
    }

    @When("I click on Add button")
    public void i_click_on() {
    	pimPage.click_add_button();
    }

    @When("I enter {string} in the first name field")
    public void i_enter_in_the_first_name_field(String firstName) {
        pimPage.enterFirstName(firstName);
    }

    @When("I enter {string} in the last name field")
    public void i_enter_in_the_last_name_field(String lastName) {
        pimPage.enterLastName(lastName);
    }
    @When("I click the save button")
    public void i_click_the_button() {
        pimPage.click_save_button();
    }
    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String expectedMessage) throws InterruptedException {
        String success_message = pimPage.Success_toast_message();
        Assert.assertTrue(success_message.contains(expectedMessage));
    }
}
