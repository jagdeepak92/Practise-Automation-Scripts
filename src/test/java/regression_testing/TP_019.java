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

public class TP_019{
	
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
	public void Network_Change()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Hi canada')]")).click();
		driver.findElement(By.linkText("Profile")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]")).click();
		//body//div[@id='countryDropdown-styler']//div//div[2]
		driver.findElement(By.xpath("//body//div[@id='countryDropdown-styler']//div//div[2]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'United States')]")).click();
		driver.findElement(By.xpath("//div[@id='stateDropdown-styler']//div[@class='jq-selectbox__trigger']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Alaska')]")).click();
		driver.findElement(By.cssSelector("div.wrapper:nth-child(7) div.container:nth-child(3) form.profileRoom:nth-child(2) div.tab-content:nth-child(2) div.tab-pane.active:nth-child(2) div.customWidth div.form-group.clearfix:nth-child(10) div.form-controls.cuSelect div.jq-selectbox.jqselect.mydropdown.changed div.jq-selectbox__select div.jq-selectbox__trigger > div.jq-selectbox__trigger-arrow")).click();
		driver.findElement(By.xpath("//li[contains(text(),'College')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'SAVE CHANGES')]")).click();
		
		List<WebElement> Profile=driver.findElements(By.xpath("//div[contains(text(),'Your profile has been updated')]"));
		actual=Profile.get(0).getText();
		expected="Your profile has been updated";
		Assert.assertEquals(expected, actual);
	}

	@Test(priority=2)
	public void Network_Older_One()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Hi canada')]")).click();
		driver.findElement(By.linkText("Profile")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]")).click();
		driver.findElement(By.xpath("//body//div[@id='countryDropdown-styler']//div//div[2]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Canada')]")).click();
		driver.findElement(By.xpath("//div[@id='stateDropdown-styler']//div[@class='jq-selectbox__trigger']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Ontario')]")).click();
		driver.findElement(By.cssSelector("div.wrapper:nth-child(7) div.container:nth-child(3) form.profileRoom:nth-child(2) div.tab-content:nth-child(2) div.tab-pane.active:nth-child(2) div.customWidth div.form-group.clearfix:nth-child(10) div.form-controls.cuSelect div.jq-selectbox.jqselect.mydropdown.changed div.jq-selectbox__select div.jq-selectbox__trigger > div.jq-selectbox__trigger-arrow")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Toronto')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'SAVE CHANGES')]")).click();
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
