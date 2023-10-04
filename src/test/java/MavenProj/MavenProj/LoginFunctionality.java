package MavenProj.MavenProj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunctionality {
	
	
	WebDriver driver;

	@Test
	public void setupandlogin(String username,String pass) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.linkedin.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[id*='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[id*='pass']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).submit();
		Assert.assertTrue(driver
				.findElement(By.xpath(
						"//a[contains(@id,'ember') and @class='ember-view block']//div[text()='Welcome, kritika!']"))
				.isDisplayed());
		//driver.quit();
	}
	
	
  @Test(enabled = false)
	public void VerifyTitle() {
		
		String actualtitle=driver.findElement(By.xpath("//title[contains(text(),'Feed | LinkedIn')]")).getText();
		System.out.println(actualtitle);

	}


	@Test(enabled = false)
	public void ForgotPass() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/login");
		driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).click();
		driver.findElement(By.cssSelector("#username")).sendKeys("kritika9648@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).submit();
		driver.quit();;

	}
	
	@Test(enabled = false)
	public void JobSearch() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("automation testing jobs");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[contains(@id,'search-reusables__filters-bar')]/ul/li/button[text()='Jobs']")).click();
		driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_UP);
	}

}
