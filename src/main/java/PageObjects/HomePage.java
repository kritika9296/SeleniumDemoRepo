package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Swag Labs')]")
	 WebElement logoname;

	@FindBy(xpath="//a[@id='item_0_title_link']/div[contains(text(),'Sauce Labs Bike Light')]")
	WebElement clickanyproduct;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement AddTocart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']/span[text()='1']")
	WebElement cart_on;
	// for returning logoname we have to create method 
	public WebElement logo() {
		//WebElement logo=logoname; // this line we only have to add if our webelement is private, if its public no issue.
		return logoname;
	}
	public WebElement clickproduct() {
		return clickanyproduct;
	}
	public WebElement AddTocart() {
		return AddTocart;
	}
	public WebElement cart_on() {
		return cart_on;
	}
	
}
