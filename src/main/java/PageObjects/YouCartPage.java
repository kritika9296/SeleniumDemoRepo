package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouCartPage {
	WebDriver driver;
	public YouCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[id='checkout']")
	WebElement checkOut;
	
	public WebElement checkOut() {
		return checkOut;
	}
	
}
