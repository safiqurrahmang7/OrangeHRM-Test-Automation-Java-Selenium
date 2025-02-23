package OrangeHRM.Cucumber.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/OrangeHRM/Cucumber/Features",
		glue = "OrangeHRM.Cucumber.StepDefinitions",
		monochrome = true,
		tags = "@Regression",
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class RegressionTestRunner extends AbstractTestNGCucumberTests {

	

}
