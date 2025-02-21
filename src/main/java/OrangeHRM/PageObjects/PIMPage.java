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
	
	@FindBy(xpath ="(//input[@autocomplete='off'])[1]")
	WebElement user_name;
	
	@FindBy(xpath ="(//input[@autocomplete='off'])[2]")
	WebElement password;
	
	@FindBy(xpath ="(//input[@autocomplete='off'])[3]")
	WebElement confirm_password;
	
	@FindBy(css=".oxd-switch-input")
	WebElement login_toggle;
	
	@FindBy(css=".oxd-toast--success")
	WebElement toast_sucess;
	
	
	public String create_emp_details(String firstName, String middleName, String lastName) {
		
		add_button.click();
		first_name.sendKeys(firstName);
		middle_name.sendKeys(middleName);
		if (lastName != null) {
		last_name.sendKeys(lastName);
		}
		return employee_id.getText();
		
	}
	
	public void create_login_details(String firstName){
		login_toggle.click();
		user_name.sendKeys(firstName+random_num());
		password.sendKeys("admin123");
		confirm_password.sendKeys("admin123");
		
	}

	public String save_emp() throws InterruptedException {
		
		save_button.click();
		element_visibility(toast_sucess);
		return toast_sucess.getText();
	}
	
	
	
}
