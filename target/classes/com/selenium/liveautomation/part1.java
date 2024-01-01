package com.selenium.liveautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class part1 {
WebDriver driver = null;
	
	@BeforeMethod
	public void setup()
	{
System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
    @Test
    public void loginRediff()
    {
    	//Open the Rediff
    	driver.get("https://www.rediff.com/");
    	//Click the money link
    	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
    	//Click the sign-in link in the money page
    	driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[1]")).click();
    	//Enter the username
    	driver.findElement(By.xpath("//*[@id=\"useremail\"]")).sendKeys("tathagatapal12@gmail.com");
    	//Enter the password
    	driver.findElement(By.xpath("//*[@id=\"userpass\"]")).sendKeys("tatha@1998");
    	//Click the submit button
    	//driver.findElement(By.xpath("//input[@value='Submit']")).click();
    	//or
    	driver.findElement(By.xpath("//input[@value='Submit']")).sendKeys(Keys.ENTER);
    	//Check whether username is displayed or not
    	driver.findElement(By.xpath("//*[@id=\"username\"]/a")).isDisplayed();
    	
    	try 
    	{
			Thread.sleep(5000);
		} 
    	catch (InterruptedException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
