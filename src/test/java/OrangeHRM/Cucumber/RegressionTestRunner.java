package OrangeHRM.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/OrangeHRM/Cucumber",
		glue = "OrangeHRM.StepDefintions",
		monochrome = true,
		tags = "@Regression",
		plugin = {"pretty",
		  "html:target/cucumber-reports/cucumber.html"}
		)
public class RegressionTestRunner extends AbstractTestNGCucumberTests{

	

}
