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
	
	
			
	
	public void click_add_button() {
		add_button.click();
	}
	public void enterFirstName(String firstName) {
		first_name.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		last_name.sendKeys(lastName);
	}
	public void click_save_button() {
		save_button.click();
	}
	
	
	
	public void toggle_login() {
		login_toggle.click();
	}
	public void enter_username(String firstName) {
		user_name.sendKeys(firstName+random_num());
	}
	
	public void enter_password(String Password) {
		password.sendKeys(Password);
		confirm_password.sendKeys(Password);
	}

	public String Success_toast_message() throws InterruptedException {
		
		
		element_visibility(toast_sucess);
		return toast_sucess.getText();
	}
	
	
	
}
