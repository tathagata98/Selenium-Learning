package com.selenium.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class xpath {
	
	@Test
	public void absolutexpath()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
	    driver.findElement(By.linkText("Sign in")).click();
	    //Using partial X-path
	    //driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Tathagata12@gmail.com");
	    driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Tathagata12@gmail.com");
	    
	    try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //Using partial x-path
	    driver.findElement(By.xpath("//div/a")).click();
	    String pagetitle=driver.getTitle();
        Assert.assertEquals(pagetitle, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
	    driver.quit();
	}
	

}
