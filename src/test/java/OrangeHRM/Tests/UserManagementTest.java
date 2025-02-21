package OrangeHRM.Tests;

import java.awt.AWTException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import OrangeHRM.PageObjects.AdminPage;
import OrangeHRM.PageObjects.DashBoardPage;
import OrangeHRM.PageObjects.PIMPage;
import OrangeHRM.TestComponents.BaseTest;
import OrangeHRM.TestComponents.RetryAnalyzer;



public class UserManagementTest extends BaseTest{
	

	@Test(dataProvider = "EmployeeData",groups = {"Purchase"},retryAnalyzer = RetryAnalyzer.class)	
	public void createEmployeeTest(String fullName, boolean hasLogin, String passowrd) throws InterruptedException {
		
		String[] name = fullName.split(" ");
		
		String first_name = name[0];
		String middle_name =  name[1];
		String last_name = name.length==3 ? name[2]:null;
		
		DashBoardPage dashboard = login.LoginApplication("Admin","admin123");
		PIMPage pim = dashboard.goToPIM();
		
		pim.create_emp_details(first_name, middle_name, last_name);
		if (hasLogin) {
			pim.create_login_details(first_name);
		}
		
		String ToastMessage = pim.save_emp();
		Boolean toast_result = ToastMessage.contains("Successfully Saved");
		Assert.assertTrue(toast_result);		
	}
	

	@Test(dataProvider = "AdminData",groups = {"Purchase"},retryAnalyzer = RetryAnalyzer.class,dependsOnMethods = {"createEmployeeTest"})
	public void createAdminTest(String fullName, boolean hasLogin, String password) throws AWTException, InterruptedException {
	
		
		String[] name = fullName.split(" ");
		String first_name = name[0];
		DashBoardPage dashboard = login.LoginApplication("Admin","admin123");
		AdminPage admin = dashboard.goToAdmin();
		admin.add_admin_with_userName(fullName,first_name);
		String toast_message = admin.success_toast();
		Boolean toaster_messager = toast_message.contains("Successfully Saved");
		Assert.assertTrue(toaster_messager);
	}
	
	

}
