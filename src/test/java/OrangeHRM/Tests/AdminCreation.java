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



public class AdminCreation extends BaseTest{
	

	

	@Test(dataProvider = "getData",groups = {"Purchase"},retryAnalyzer = RetryAnalyzer.class)
	public void UserCreationTest(HashMap<String,String> fullName) throws AWTException, InterruptedException {
	
		
		//UserNames
		String[] name = fullName.get("userName").split(" ");
		
		String first_name = name[0];
		String middle_name =  name[1];
		String last_name = name.length==3 ? name[2]:null;
		
		DashBoardPage dashboard = login.LoginApplication("Admin","admin123");
		PIMPage pim = dashboard.goToPIM();
		
		pim.add_employee_without_userName(first_name, middle_name, last_name);
		
		AdminPage admin = pim.goToAdmin();
		admin.add_admin_with_userName(fullName.get("userName"),first_name);
		String toast_message = admin.success_toast();
		Boolean toaster_messager = toast_message.contains("Successfully Saved");
		Assert.assertTrue(toaster_messager);
	}

}
