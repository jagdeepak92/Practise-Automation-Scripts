package regression_testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TP_008{
	
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
	public void Creating_Need()
	{
		driver.findElement(By.xpath("//span[@class='w-icons-caret']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Need')]")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Need Helicopter");
		driver.findElement(By.xpath("//div[@id='category_id-styler']//div[@class='jq-selectbox__trigger-arrow']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Computer & Phone')]")).click();
		driver.findElement(By.xpath("//input[@id='price']")).sendKeys("1000");
		//driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-state-default ui-corner-all ui-state-hover']")).click();
		//driver.findElement(By.xpath("//input[@id='refund_valid']")).sendKeys("4");
		driver.findElement(By.xpath("//li[1]//span[1]//label[1]")).click();
		driver.findElement(By.xpath("//ul[@class='line-btn pull-right']//button[@class='btn btn-success w-btn-success']")).click();
		List<WebElement> create=driver.findElements(By.xpath("//div[contains(text(),'Need has been added')]"));
		actual=create.get(0).getText();
		expected="Need has been added";
		Assert.assertEquals(expected, actual);
	}
	@Test(priority=2)
	public void Updating_Need()
	{
		driver.findElement(By.xpath("//input[@id='exampleInputAmount']")).sendKeys("Need Helicopter");
		driver.findElement(By.xpath("//button[@class='btn-search']")).click();
		driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[2]//div[1]//a[1]")).click();
		driver.findElement(By.xpath("//a[@class='pull-right edit-link']")).click();
		driver.findElement(By.xpath("//input[@id='price']")).clear();
		driver.findElement(By.xpath("//input[@id='price']")).sendKeys("500");
		driver.findElement(By.xpath("//ul[@class='line-btn pull-right']//button[@class='btn btn-success w-btn-success']")).click();
		List<WebElement> update=driver.findElements(By.xpath("//div[contains(text(),'Need has been updated')]"));
		actual=update.get(0).getText();
		expected="Need has been updated";
		Assert.assertEquals(expected, actual);
	}
	@Test(priority=3)
	public void Delete_Need() 
	{	
			driver.findElement(By.xpath("//body/div[@class='wrapper']/nav[@class='navbar navbar-inverse navbar-fixed-top']/div[@class='inner-container']/div[@class='navbar-collapse pull-right']/ul[@class='nav navbar-nav']/li[4]/a[1]")).click();
			driver.findElement(By.linkText("Profile")).click();
		 	driver.findElement(By.xpath("//tr[1]//td[2]//ul[1]//li[2]//a[1]")).click();
			driver.findElement(By.xpath("//a[@id='btn_deleteService']")).click();
			List<WebElement> delete=driver.findElements(By.xpath("//div[contains(text(),'Need has been deleted')]"));
			actual=delete.get(0).getText();
			expected="Need has been deleted";
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
