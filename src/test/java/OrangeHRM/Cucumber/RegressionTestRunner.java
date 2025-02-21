package OrangeHRM.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/OrangeHRM/Cucumber",
		glue = "OrangeHRM.StepDefintions",
		monochrome = true,
		tags = "@Regression",
		plugin = { "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
		)
public class RegressionTestRunner extends AbstractTestNGCucumberTests {

	

}
