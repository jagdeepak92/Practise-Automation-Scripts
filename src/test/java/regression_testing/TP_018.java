package regression_testing;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.List.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TP_018{
	
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
	public void Refund()
	{
	
		driver.findElement(By.xpath("//span[contains(text(),'Transactions')]")).click();
		driver.findElement(By.cssSelector("div.wrapper:nth-child(7) div.container.mobile-grid-table:nth-child(2) table.table-Colorful.color-3.stacktable.large-only:nth-child(3) tbody:nth-child(2) tr:nth-child(1) td:nth-child(7) a.servicerefund.default:nth-child(1) > i.w-icons-dollar")).click();
		driver.findElement(By.xpath("//button[@id='btn_refundService']")).click();
		List<WebElement>refund=driver.findElements(By.id("refundmessagecontent"));
		actual="refund valid";
		expected="refund valid";
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