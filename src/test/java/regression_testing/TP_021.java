package regression_testing;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.List.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TP_021{
	
	public String baseURL="https://qatest.twoplugs.com/";
	public WebDriver driver;
	public String actual;
	public String expected;

	@BeforeTest
	public void Launch_Browser()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void Verify_homepage() 
	{
		actual=driver.getTitle();
		expected="twoPLUGS - A plug for your Service and another for your Need";
		Assert.assertEquals(expected, actual);
		
	}
	
	
	@Test(priority=0)
  public void valid_login() 
	{
		driver.findElement(By.xpath("//span[contains(text(),'LOG IN')]")).click();
		driver.findElement(By.xpath("//input[@id='signInEmail']")).sendKeys("canada@mailinator.com");
		driver.findElement(By.xpath("//input[@id='signInPassword']")).sendKeys("WinterIsComing@123");
		driver.findElement(By.xpath("//span[contains(text(),'LOG IN')]")).click();
		actual=driver.getCurrentUrl();
		expected="https://qatest.twoplugs.com/home";
		Assert.assertEquals(expected, actual);
  }
	
	@Test(priority=1)
	public void Email_new()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Hi canada')]")).click();
		driver.findElement(By.linkText("Settings")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		//driver.findElement(By.xpath("//input[@name='new_email_verify']")).clear();
		//driver.findElement(By.xpath("//input[@name='new_email_verify']")).sendKeys(arg0);
		driver.findElement(By.xpath("//input[@name='new_email']")).sendKeys("punjab@gmail.com");
		driver.findElement(By.xpath("//input[@name='confirm_email']")).sendKeys("punjab@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name,'new_email_password')]")).sendKeys("WinterIsComing@123");
		driver.findElement(By.xpath("//span[contains(text(),'SAVE CHANGES')]")).click();
		List<WebElement> email=driver.findElements(By.xpath("//div[contains(text(),'Your email has been updated')]"));
		actual=email.get(0).getText();
		expected="Your email has been updated";
		Assert.assertEquals(expected, actual);
		
	}

	@Test(priority=2)
	public void older_email()
	{
	
		driver.findElement(By.xpath("//span[contains(text(),'Hi canada')]")).click();
		driver.findElement(By.linkText("Settings")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.xpath("//input[@name='new_email']")).sendKeys("canada@mailinator.com");
		driver.findElement(By.xpath("//input[@name='confirm_email']")).sendKeys("canada@mailinator.com");
		driver.findElement(By.xpath("//input[contains(@name,'new_email_password')]")).sendKeys("WinterIsComing@123");
		driver.findElement(By.xpath("//span[contains(text(),'SAVE CHANGES')]")).click();
		List<WebElement> email=driver.findElements(By.xpath("//div[contains(text(),'Your email has been updated')]"));
		actual=email.get(0).getText();
		expected="Your email has been updated";
		Assert.assertEquals(expected, actual);
	
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
@AfterMethod
public void Reset()
{
		driver.findElement(By.xpath("//a[@class='navbar-brand']//img")).click();
		expected="twoPLUGS - A plug for your Service and another for your Need";
		actual=driver.getTitle();
		Assert.assertEquals(expected, actual);
}
@AfterTest
public void Quit_Browser()
{
driver.quit();	
}

}
