package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutInfoPage {
	WebDriver driver;

	public CheckOutInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='first-name']")
	WebElement FirstName_info;

	@FindBy(xpath="//input[@id='last-name']")
	WebElement LastName_info;

	@FindBy(id="postal-code")
	WebElement Pincode_info;
	
	@FindBy(id="continue")
	WebElement Continue;
	

	public WebElement FirstName() {
		return FirstName_info;
	}

	public WebElement LastName() {
		return LastName_info;
	}

	public WebElement Pincode() {
		return Pincode_info;
	}
	
	public WebElement submit() {
		return Continue;
	}

}
