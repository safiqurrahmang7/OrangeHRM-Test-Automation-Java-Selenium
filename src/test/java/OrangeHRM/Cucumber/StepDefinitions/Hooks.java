package OrangeHRM.Cucumber.StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import OrangeHRM.PageObjects.LoginPage;
import OrangeHRM.TestComponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends BaseTest {
	
	public static LoginPage loginPage;
	public static WebDriver driver;
	
	
	@Before
	public void beforeScenario() throws IOException {
		
		driver = driverInitializer();
		loginPage = new LoginPage(driver);
		loginPage.sandbox();
	   	}
	
	
	@AfterStep
	public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed() && driver != null) { // Check if driver is initialized
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] src = ts.getScreenshotAs(OutputType.BYTES);
                
                // Sanitize scenario name to avoid invalid file name issues
                String scenarioName = scenario.getName();

                scenario.attach(src, "image/png", scenarioName + "_screenshot");
            } catch (Exception e) {
                System.out.println("Screenshot capture failed: " + e.getMessage());
            }
        }
    }
	
	@After
	public void afterScenario() {
		
		driver.quit();
	}
	
	
}
