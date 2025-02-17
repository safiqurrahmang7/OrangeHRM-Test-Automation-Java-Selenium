package OrangeHRM.resuorces;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportNG {



	
	public static ExtentReports reporterNG() {
		
		String path = System.getProperty("user.dir")+"//Reports//"+"index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Orange-HRM Test Result");
		report.config().setDocumentTitle("Orange-HRM");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		
		return extent;
		
	}

}
