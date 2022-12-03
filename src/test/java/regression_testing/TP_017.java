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

public class TP_017{
	
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
	public void File_Complaint()
	{
	
		driver.findElement(By.xpath("//span[contains(text(),'Transactions')]")).click();
		driver.findElement(By.xpath("//nav[@class='text-center']//li[3]//a[1]")).click();
		driver.findElement(By.cssSelector("div.wrapper:nth-child(7) div.container.mobile-grid-table:nth-child(2) table.table-Colorful.color-3.stacktable.large-only:nth-child(3) tbody:nth-child(2) tr:nth-child(6) td:nth-child(7) a:nth-child(1) > i.w-icons-flag")).click();
		driver.findElement(By.xpath("//tr[6]//td[7]//a[1]//i[1]")).click();
		driver.findElement(By.xpath("//input[@id='reportSubject']")).sendKeys("Bad Servcie");
		driver.findElement(By.xpath("//textarea[contains(@placeholder,'Complaint content')]")).sendKeys("bad attitude");
		driver.findElement(By.xpath("//span[contains(text(),'Submit complaint')]")).click();
		List<WebElement> complaint=driver.findElements(By.xpath("//div[contains(text(),'Your complaint has been submitted. You will be con')]"));
		actual=complaint.get(0).getText();
		System.out.println(actual);
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
