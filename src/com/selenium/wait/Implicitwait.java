package com.selenium.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Implicitwait {
	
	@Test
	public void testImplicitwait()
	{
System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		//Apply implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q' and @title='Search']")).sendKeys("Selenium-webdriver");
		//Use various X-paths whichever you feel like
		//driver.findElement(By.xpath("//li[@role='presentation'][3]")).click();
		driver.findElement(By.xpath("//li[@class='sbct'][3]")).click();

        //driver.quit();  

	}

}
