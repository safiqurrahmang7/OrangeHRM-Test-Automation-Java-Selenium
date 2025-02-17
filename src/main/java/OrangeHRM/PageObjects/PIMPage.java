package OrangeHRM.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHRM.AbstractComponents.PageComponents;

public class PIMPage extends PageComponents{

	
	WebDriver driver;
	
	public PIMPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".orangehrm-header-container .oxd-button--secondary")
	WebElement add_button;
	
	@FindBy(css="input[name$='firstName']")
	WebElement first_name;
	
	@FindBy(css="input[name$='middleName']")
	WebElement middle_name;
	
	@FindBy(css="input[name$='lastName']")
	WebElement last_name;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement employee_id;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save_button;
	
	@FindBy(css=".oxd-text.oxd-text--h6.--strong")
	WebElement name_label;
	
	
	
	
	public void add_employee_without_userName(String firstName, String middleName, String lastName) throws InterruptedException {
		
		add_button.click();
		first_name.sendKeys(firstName);
		middle_name.sendKeys(middleName);
		if (lastName != null) {
		last_name.sendKeys(lastName);
		}
		employee_id.getText();
		save_button.click();
		Thread.sleep(2000);
		
	}
	
	
	
}
