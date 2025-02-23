package OrangeHRM.TestComponents;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import OrangeHRM.resources.ExtentreportNG;





public class TestListener extends BaseTest implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent =  ExtentreportNG.reporterNG();
	
	
	@Override  
	public void onTestStart(ITestResult result) {  
	
		test = extent.createTest(result.getMethod().getMethodName());
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  

		test.log(Status.PASS, "Test Passed");
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
		
		test.fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			String path = null;
			try {
				path = getScreenshot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			test.addScreenCaptureFromPath(path,result.getMethod().getMethodName());
		
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}    
	  
	@Override  
	public void onStart(ITestContext context) {  
	 
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
	
		extent.flush();
		
	}  
	
}  	


