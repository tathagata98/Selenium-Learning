package com.selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class check 
{
	WebDriver driver=null;
	
	@BeforeMethod
	public void open()
	{
		System.setProperty("webdriver.chrome.driver","F:\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void openurl()
	{
		driver.get("https://www.google.com/");
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
