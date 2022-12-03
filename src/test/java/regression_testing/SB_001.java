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

public class SB_001{
	
	public String baseURL="https://slidebean.com/";
	public WebDriver driver;
	public String actual;
	public String expected;

	@BeforeTest
	public void Launch_Browser()//this will launch browser
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	
	
	@Test(priority=0)
  public void valid_login() 	
	{
		

		driver.findElement(By.xpath("//div[@class='navbar-loginctas']"));
		driver.findElement(By.cssSelector("div.sb-newnavbar.w-nav:nth-child(1) div.max1500w div.sb-newnavbardiv2 div.navbar-loginctas > a.sb-newnavbar-link.w-nav-link")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@placeholder='example@email.com']")).sendKeys("bqatuser9@mailinator.com");
        driver.findElement(By.xpath("//div[@class='input-group']//input[@class='form-control ng-untouched ng-pristine ng-invalid']")).sendKeys("TEST2PLUG9");
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-block btn-primary btn-rounded']")).click();
        
	
  }
	@Test(priority=1)
	public void Update_profile()// this will update profile
	{
		
		driver.findElement(By.xpath("//body/app-root/sb-dashboard/sb-page-container/section/div/div/sb-presentations/sb-top-bar/nav/div/sb-user-dropdown/div/a/i[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Jon Snow']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Jon Snow']")).sendKeys("Jagdeepak");
        driver.findElement(By.xpath("//div[@class='form-group']//button[@class='btn btn-primary']")).click();
        List<WebElement> links = driver.findElements(By.xpath("//span[contains(text(),'Profile updated')]"));
        actual=(links.get(0).getText());
		expected="Profile updated";
		Assert.assertEquals(expected, actual);
	
		
	}
	@AfterTest
	public void QuitBrowser()
	{
		driver.quit();
	}
}
