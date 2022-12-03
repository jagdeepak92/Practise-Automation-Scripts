package regression_testing;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TP_001 
{

	public String BaseUrl="https://qatest.twoplugs.com/";
	public WebDriver driver;
	public String expected;
	public String actual;
	
	
@BeforeTest
public void LaunchWebsite()
{
	System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(BaseUrl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
	
	
@BeforeMethod
public void  Verify_HomePage()
{
	actual=driver.getTitle();
	expected="twoPLUGS - A plug for your Service and another for your Need";
	Assert.assertEquals(actual, expected);
}
	
	
	
	@Test
  public void CheckUser() 
  {
		driver.findElement(By.xpath("//ul[@class='control-bar']//span[@class='help'][contains(text(),'Join Now For Free')]")).click();
		driver.findElement(By.xpath("//input[@id='signUpUser']")).sendKeys("Canda@$%^&");
		driver.findElement(By.xpath("//input[@id='signUpEmail']")).sendKeys("plague@#$21.");
		driver.findElement(By.xpath("//input[@id='signUpPassword']")).sendKeys("okjhgh!@#$9876");
		driver.findElement(By.xpath("//button[@class='btn btn-success w-btn-success wide']")).click();
		
  }

@AfterMethod
	public void Reset() 
{
	driver.findElement(By.xpath("//a[@class='navbar-brand']//img")).click();
	actual=driver.getTitle();
	expected="twoPLUGS - A plug for your Service and another for your Need";
	Assert.assertEquals(actual, expected);
		
	
}

@AfterTest
public void Quit_browser()
{
	driver.quit();
	
}
	
}



