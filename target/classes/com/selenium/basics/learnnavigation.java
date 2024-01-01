package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class learnnavigation 
{
	ChromeDriver driver;
	@BeforeMethod
	public void openbrowser()
	{
		//FirefoxDriver driver=(FirefoxDriver)WebDriverManager.firefoxdriver().create();
		
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:1115");
		driver=(ChromeDriver)WebDriverManager.chromedriver().create();
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.get("https://www.javatpoint.com/");
		//driver.navigate().to("https://www.flipkart.com/");
	}
	@Test
public void learnnavigation()
{
		
	driver.navigate().back();// Navigates back to amazon after opening flipkart
	driver.navigate().forward();// Navigates back to flipkart after opening amazon
	driver.navigate().refresh();//Refreshes the webpage.
}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
}

