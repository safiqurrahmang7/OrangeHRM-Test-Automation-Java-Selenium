package OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import OrangeHRM.AbstractComponents.PageComponents;

public class DashBoardPage extends PageComponents {
	
	WebDriver driver;
	public DashBoardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
}
