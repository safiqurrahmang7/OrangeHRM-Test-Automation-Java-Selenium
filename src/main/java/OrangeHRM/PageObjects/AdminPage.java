package OrangeHRM.PageObjects;



import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHRM.AbstractComponents.PageComponents;

public class AdminPage extends PageComponents{

	WebDriver driver;
	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(css = ".orangehrm-header-container .oxd-button--secondary")
	WebElement add_button;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	WebElement user_role;
	
	@FindBy(css="input[placeholder='Type for hints...']")
	WebElement employee_name;
	
	@FindBy(xpath="//div[@role='listbox']")
	WebElement listbox;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	WebElement status;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement user_field;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement Password;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement confirm_password;
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(css=".oxd-toast--success")
	WebElement toast_sucess;
	
	public void add_admin_with_userName(String name,String first_name,String password) throws AWTException, InterruptedException {
		
		add_button.click();
		user_role.click();
		dropdown_selection();
		employee_name.sendKeys(name);
		Thread.sleep(4000);
		dropdown_selection();
		status.click();
		dropdown_selection();
		user_field.sendKeys(first_name+random_num());
		Password.sendKeys(password);
		confirm_password.sendKeys(password);
		submit.click();
		
	}
	
	public String success_toast() throws InterruptedException {
		Thread.sleep(3000);
		return toast_sucess.getText();
		
	}
	
	
}
