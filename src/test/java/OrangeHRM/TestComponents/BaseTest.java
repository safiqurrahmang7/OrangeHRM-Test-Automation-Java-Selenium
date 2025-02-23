package OrangeHRM.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

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
	public static Properties properties;
	
	static {
		
		try {
			properties = new Properties();
			FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\OrangeHRM\\resources\\Global.properties");
			properties.load(input);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public WebDriver driverInitializer() throws IOException {
		
		String browserName = properties.getProperty("browser");
		
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
	
	
	
	
	
	
	public String getScreenshot(String TestCaseName,WebDriver driver) throws IOException {
    	
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	File file = new File(System.getProperty("user.dir")+"//reports//"+"//ExtentTestNG//"+TestCaseName+".png");
    	FileUtils.copyFile(source,file);
    	return System.getProperty("user.dir")+"//reports//"+"//ExtentTestNG//"+TestCaseName+".png";
    	
    }
	
	public List<Object[]> employee_lists() {
		
		 List<Object[]> employees = new ArrayList<>();

	        
	        int employeeIndex = 1;
	        while (properties.containsKey("employee" + employeeIndex + ".username")) {
	            String prefix = "employee" + employeeIndex;
	            String name = properties.getProperty(prefix + ".username", "Unknown");
	            boolean hasLogin = Boolean.parseBoolean(properties.getProperty(prefix + ".has_login", "false"));
	            String password = properties.getProperty(prefix + ".password", "N/A");

	            employees.add(new Object[]{name, hasLogin,password});
	            employeeIndex++;
	        }
	        
	        return employees;
		
	}
		
	
	
	@DataProvider
	public Object[][] EmployeeData() throws IOException {
		
		 List<Object[]> employees =employee_lists();

	        return employees.toArray(new Object[employees.size()][]);
	}
	
	@DataProvider
	public Object[][] AdminData() throws IOException {
		
		List<Object[]> employees =employee_lists();
        List<Object[]> admin = employees.stream().filter(emp-> !(boolean)emp[1]).collect(Collectors.toList());

        return admin.toArray(new Object[admin.size()][]);
	}
}
