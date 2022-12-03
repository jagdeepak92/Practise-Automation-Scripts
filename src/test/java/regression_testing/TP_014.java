package regression_testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TP_014 {
  public String baseURL="https://qatest.twoplugs.com/";
  public WebDriver driver;
  public String actual;
  public String expected;
	@BeforeTest
	public void Launch_Browser()
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
	}
	@BeforeMethod
	public void Verify_Homepage()
	{
		actual=driver.getTitle();
		expected="twoPLUGS - A plug for your Service and another for your Need";
		Assert.assertEquals(actual, expected);
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
		public void Transfer_eeds()
		{
			driver.findElement(By.xpath("//input[@id='exampleInputAmount']")).sendKeys("Stealth");
			List<WebElement> links=driver.findElements(By.xpath("//div[@class='searchSuggest']"));
			links.get(0).click();		// this  will click on the user profile
			
		
			
			driver.findElement(By.xpath("//span[@class='w-icons-profileCtrl2']")).click();
			driver.findElement(By.xpath("//input[@id='transferAmount']")).sendKeys("10");
			driver.findElement(By.id("transfer_id")).click();
			driver.findElement(By.xpath("//a[@id='btn_transfer']//span[@class='help'][contains(text(),'Transfer')]")).click();
			List<WebElement> eeds=driver.findElements(By.xpath("//div[contains(text(),'Credit Transfer was successful')]"));
			actual=(eeds.get(0).getText());
			expected="Credit Transfer was successful";
			Assert.assertEquals(actual, expected);
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
