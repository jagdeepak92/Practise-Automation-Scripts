package com.org.learningMaven.DemoBlaze.Checkout_Demo_Blaze;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Checkout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String BaseURL="https://www.demoblaze.com/index.html";
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='tbodyid']//div[1]//div[1]//a[1]//img[1]")).click();
		List<WebElement> Links=driver.findElements(By.xpath("//h2[@class='name']"));
		List<WebElement> Desc=driver.findElements(By.xpath("//div[@id='more-information']"));
		String Name=Links.get(0).getText();
		//System.out.println(Name);
		String Actual_result="Samsung galaxy s6";
		int i=0;
		String Description=Desc.get(i).getText();
		
		//System.out.println(Description);
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click(); 
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		if(Name.equals(Actual_result))
		{	
			System.out.println("You Clicked on"+" : "+Name);
			System.out.println("TestCase Passed!!");
		}
		driver.close();
		
		
	}

}
