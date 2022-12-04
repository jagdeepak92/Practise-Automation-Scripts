package com.org.learningMaven.DemoBlaze.Checkout_Demo_Blaze ;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Checkout2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.xpath("//div[@id='tbodyid']//div[1]//div[1]//a[1]//img[1]")).click();
		
		driver.findElement(By.xpath("//a[@onclick=\"addToCart(1)\"]")).click();
		Thread.sleep(3000);
		
		
		Alert alt =driver.switchTo().alert();
		alt.accept();
		
	}

}
