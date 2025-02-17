package OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHRM.AbstractComponents.PageComponents;

public class LoginPage extends PageComponents {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input[name$='username']")
	private WebElement username;
	
	@FindBy(css="input[name$='password']")
	private WebElement password;
	
	@FindBy(css="button")
	private WebElement loginButton;
	
	public void sandbox() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	public DashBoardPage LoginApplication(String UserName,String Password) {
		
		username.sendKeys(UserName);
		password.sendKeys(Password);
		loginButton.click();
		return new DashBoardPage(driver);
		
	}
}
