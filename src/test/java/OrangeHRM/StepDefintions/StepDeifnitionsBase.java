package OrangeHRM.StepDefintions;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;

import OrangeHRM.PageObjects.AdminPage;
import OrangeHRM.PageObjects.DashBoardPage;
import OrangeHRM.PageObjects.LoginPage;
import OrangeHRM.PageObjects.PIMPage;
import OrangeHRM.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDeifnitionsBase extends BaseTest{
	LoginPage login;
	PIMPage pim;
	AdminPage admin;
	DashBoardPage dashboard;
	@Given("Launch the application")
	public void launch_the_application() throws IOException {
		
		login = setup();
		
	}
	
	@Given("Login the application with username {string} and password {string}")
	public void Login_the_application(String username,String password) {
		
				
		dashboard= login.LoginApplication(username,password);
		pim = dashboard.goToPIM();
	}
	@When("create the employee {string} without the username")
	public void create_the_employee_without_username(String fullName) throws InterruptedException {
		
		String[] name = fullName.split(" ");
		
		String first_name = name[0];
		String middle_name =  name[1];
		String last_name = name.length==3 ? name[2]:null;
		pim.create_emp_details(first_name, middle_name, last_name);
		pim.save_emp();
	}
	
	@When ("create the Admin with username {string}")
	public void add_admin_with_username(String fullName) throws AWTException, InterruptedException {
		String[] name = fullName.split(" ");
		
		String first_name = name[0];
		admin = pim.goToAdmin();
		admin.add_admin_with_userName(fullName,first_name);
	}
	
	@Then("Toaster Message should be displayed as {string}")
	public void verify_the_toastMessage(String Toaster) throws InterruptedException {
		
		String toast_message = admin.success_toast();
		Boolean toaster_messager = toast_message.contains(Toaster);
		Assert.assertTrue(toaster_messager);
		driver.quit();
	}
	


}
