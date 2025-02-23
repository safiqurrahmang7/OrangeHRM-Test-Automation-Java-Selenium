package OrangeHRM.AbstractComponents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import OrangeHRM.PageObjects.AdminPage;
import OrangeHRM.PageObjects.PIMPage;

public class PageComponents {
	WebDriver driver;
	
	public PageComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".oxd-main-menu-item")
	List<WebElement> menuItems;
	
	public void menuItem_selection(String menuItem) {
		
		WebElement menu_item = menuItems.stream().filter(menu ->
		menu.getText().equalsIgnoreCase(menuItem)).findFirst().orElse(null);		
		menu_item.click();
	}
	
	public <T> T goTo(String module, Class<T> pageClass) {
	    menuItem_selection(module);
	    try {
	        return pageClass.getConstructor(WebDriver.class).newInstance(driver);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to navigate to: " + module, e);
	    }
	}
	
	public void dropdown_selection() throws AWTException {
			
		Robot rob = new Robot();
		
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyRelease(KeyEvent.VK_DOWN);
		rob.delay(200);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
			
		}
	public void element_visibility(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public int random_num() {
		
		return (int)(Math.random()*100);
				
	}
}
