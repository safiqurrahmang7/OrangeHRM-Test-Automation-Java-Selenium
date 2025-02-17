package OrangeHRM.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import OrangeHRM.PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPage login;
	public WebDriver driverInitializer() throws IOException {
		
		Properties property = new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\OrangeHRM\\resuorces\\Global.properties");
		property.load(input);
		String browserName = property.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")){
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage setup() throws IOException {
		driver = driverInitializer();
		login = new LoginPage(driver);
		login.sandbox();
		return login;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.quit();
	}
	
	public String getScreenshot(String TestCaseName,WebDriver driver) throws IOException {
    	
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	File file = new File(System.getProperty("user.dir")+"//reports//"+TestCaseName+".png");
    	FileUtils.copyFile(source,file);
    	return System.getProperty("user.dir")+"//reports//"+TestCaseName+".png";
    	
    }
	public List<HashMap<String,String>> jsonReader(String path) throws IOException{
		
		String content = FileUtils.readFileToString(new File(path),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(content, new TypeReference<List<HashMap<String,String>>>() {
		});
		
		return data;
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>> data = jsonReader(System.getProperty("user.dir")+"\\src\\test\\java\\OrangeHRM\\Data\\admin.json"); 
		return new Object[][] {
				{data.get(0)},
				{data.get(1)},
				{data.get(2)},
		
		};
	}
}
