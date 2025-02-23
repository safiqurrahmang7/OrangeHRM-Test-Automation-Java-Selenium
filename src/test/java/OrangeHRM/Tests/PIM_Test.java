package OrangeHRM.Tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OrangeHRM.PageObjects.LoginPage;
import OrangeHRM.PageObjects.PIMPage;
import OrangeHRM.TestComponents.BaseTest;

public class PIM_Test extends BaseTest {

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		
		driver = driverInitializer();
	    login = new LoginPage(driver);
	    login.sandbox();
	    login.LoginApplication("Admin","admin123");
	    
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.quit();
	}

	@DataProvider
	public Object[][] EmployeeData() throws IOException {
		
		 List<Object[]> employees =employee_lists();

	        return employees.toArray(new Object[employees.size()][]);
	}
	
	
	
	@Test(groups="Regression",dataProvider = "EmployeeData")
	public void create_employee_test(String fullName,Boolean hasLogin,String password) throws InterruptedException {
		
		String[] name = fullName.split(" ");
		String firstName = name[0];
		String lastName = name[1];
		
		PIMPage pimPage = login.goTo("PIM", PIMPage.class);
		pimPage.click_add_button();
		pimPage.enterFirstName(firstName);
		pimPage.enterLastName(lastName);
		if (hasLogin) {
			
			pimPage.toggle_login();
			pimPage.enter_username(firstName);
			pimPage.enter_password(password);
			
			
		}
		pimPage.click_save_button();
		String successMessage = pimPage.Success_toast_message();
		Assert.assertTrue(successMessage.contains("Successfully Saved"));		
	}
	
	
	
}
