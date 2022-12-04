package com.org.learningMaven.DemoBlaze.Checkout_Demo_Blaze;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Opencart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String BaseURl="http://demo.automationtesting.in/Register.html";
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(BaseURl);
		/*
		List<WebElement>links=driver.findElements(By.className("form-group"));
				for (int i=0;i<links.size();i++)
		
		{	
					System.out.println(links.size());
					System.out.println(links.get(i).getText());
		}
	
		
		*/
		//http://demo.automationtesting.in/Register.html
		String url="http://demo.automationtesting.in/WebTable.html";
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("jagdeepak",Keys.TAB);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Verka",Keys.TAB,"8 Roehampton Crescent",Keys.TAB,"Jagdeepak0002@gmail.com",Keys.TAB,"6475545020",Keys.TAB,Keys.SPACE,Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,Keys.TAB);
		driver.findElement(By.id("msdd")).click();
		driver.findElement(By.linkText("English")).click();
		driver.findElement(By.linkText("Czech")).click();
		new Select (driver.findElement(By.xpath("//select[@id='Skills']"))).selectByVisibleText("C++");
		new Select (driver.findElement(By.xpath("//select[@id='countries']"))).selectByVisibleText("Austria");
		driver.findElement(By.xpath("//span[@class='select2-selection__arrow']//b")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Bangladesh')]")).click();
		new Select (driver.findElement(By.cssSelector("#yearbox"))).selectByVisibleText("2007");
		new Select (driver.findElement(By.xpath("//select[@placeholder='Month']"))).selectByVisibleText("August");
		new Select(driver.findElement(By.xpath("//select[@id='daybox']"))).selectByVisibleText("29");
		
		driver.findElement(By.id("firstpassword")).sendKeys("Alphabets123",Keys.TAB,"Alphabets123",Keys.TAB,Keys.ENTER);
		System.out.println(driver.getTitle());
		String curent=driver.getCurrentUrl();
		System.out.println(curent);
		if (url.equals(curent))
		{
			System.out.println("testcase passed!!");
		}
		else 
		{
			System.out.println("fails");
		}
		//driver.close();
	}

}
