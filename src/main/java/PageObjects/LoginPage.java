package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
 WebDriver driver;
 
 public LoginPage(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(css="input[id*='user-name']")
 private WebElement username;
 
 //private By username= By.cssSelector("input[id*='user-name']");
 private By Pass= By.cssSelector("input[id*='password']");
 private By loginbutton= By.xpath("//input[@name='login-button']");
 
 
 public WebElement CallUserid() {
	 WebElement userid = username;
	 return userid;
 }
 
 public WebElement CallPwd() {
	 WebElement Pwd = driver.findElement(Pass);
	 return Pwd;
 }
 
 public WebElement CallSubmit() {
	 WebElement submit = driver.findElement(loginbutton);
	 return submit;
 }
	
}
