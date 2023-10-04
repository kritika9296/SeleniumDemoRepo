package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.h;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CheckOutInfoPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.YouCartPage;
import resources.Base;

public class LoginTest extends Base {
	WebDriver driver;
	Logger log;

	@Test
	public void login() throws IOException, InterruptedException {

		LoginPage login = new LoginPage(driver);
		// login.CallUserid().sendKeys("standard_user"); // this is hardcoded so will
		// update it form property file now.
		login.CallUserid().sendKeys(prop.getProperty("Loginid"));
		log.debug("Email addressed got entered");
		login.CallPwd().sendKeys(prop.getProperty("Loginpass"));
		log.debug("Password got entered");
		login.CallSubmit().click();
		log.debug("Clicked on Login Button");
		HomePage H = new HomePage(driver);
		String ActualResult = null;
		try {
			if (H.logo().isDisplayed()) {
				log.debug("User got logged in");
				ActualResult = "Successfully logged in!";
			}
		} catch (Exception e) {
			log.debug("User didn't log in");
			ActualResult = "Not able to login in";
		}
		if(ActualResult.equals(H.logo())) 
			log.info("Login Test got passed");
		else
			log.error("Login Test got failed");

	}

	@BeforeMethod()
	public void openApplication() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializebrowser(); // this will initialize browser from BAse file.
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@Test
	public void addToCart() throws InterruptedException, IOException {
		login();
		HomePage H = new HomePage(driver);
		String ActualProd = H.clickproduct().getText();
		if (ActualProd.equals("Sauce Labs Bike Light")) {
			H.AddTocart().click();
			Thread.sleep(7000);
		}
		String cartvalue = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		int cartvalue2 = Integer.valueOf(cartvalue);
		System.out.println(cartvalue2);
		if (cartvalue2 >= 1) {
			driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		}
	}

	@Test
	public void checkout() throws InterruptedException, IOException {
		addToCart();
		YouCartPage Y = new YouCartPage(driver);
		Y.checkOut().click();
	}

	@Test
	public void YourInfo() throws InterruptedException, IOException {
		checkout();
		CheckOutInfoPage C = new CheckOutInfoPage(driver);
		C.FirstName().sendKeys("Rishi");
		C.LastName().sendKeys("Sharma");
		C.Pincode().sendKeys("226021");
		C.submit().click();
	}

	/*
	 * @AfterMethod public void closure() { driver.close();
	 * log.debug("Browser got closed"); }
	 */

}
