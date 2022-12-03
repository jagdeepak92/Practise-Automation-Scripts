package regression_testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SB_002 {
	String baseUrl="https://slidebean.com/";// to get url of website
	public WebDriver driver;
	public String expected= null;// variables are made public to be used anywhere in class
	public String actual =null;
	
	@BeforeTest
	public void launchwebsite() {// will launch website
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();//used to run test on chromedriver
		driver.get(baseUrl);
		driver.manage().window().maximize();//used for maximizing screen
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//when  computer is slow this helps in synchronizing
	}
		
	@BeforeMethod
	public void verifyHomepageTitle() {// assertion applied to check homepage title 
		String expected="https://slidebean.com/";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual,expected);
	
	}
	@AfterTest
	public void closeWebsite() {// will close browser
		driver.quit();
	}
	  @Test
	  public void profile() {
	   driver.findElement(By.xpath("//div[@class='navbar-loginctas']"));
		driver.findElement(By.cssSelector("div.sb-newnavbar.w-nav:nth-child(1) div.max1500w div.sb-newnavbardiv2 div.navbar-loginctas > a.sb-newnavbar-link.w-nav-link")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@placeholder='example@email.com']")).sendKeys("bqatuser2@mailinator.com");
        driver.findElement(By.xpath("//div[@class='input-group']//input[@class='form-control ng-untouched ng-pristine ng-invalid']")).sendKeys("TEST2PLUG9");
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-block btn-primary btn-rounded']")).click();
        driver.findElement(By.xpath("//body/app-root/sb-dashboard/sb-page-container/section/div/div/sb-presentations/sb-top-bar/nav/div/sb-user-dropdown/div/a/i[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();
        
        //UPDATE PROFILE
        driver.findElement(By.xpath("//input[@placeholder='Jon Snow']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Jon Snow']")).sendKeys("SUPREET");
        driver.findElement(By.xpath("//div[@class='form-group']//button[@class='btn btn-primary']")).click();
        actual = driver.findElement(By.xpath("//span[contains(text(),'Profile updated')]")).getText();
        
        expected= "Profile updated";
        //Assertion
        Assert.assertEquals(expected, actual);
	  
	  


}

}