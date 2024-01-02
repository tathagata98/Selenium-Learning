package com.selenium.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CNNtest {
	@Test
	public void testing()
	{
System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		driver.get("https://edition.cnn.com/");
		Assert.assertEquals(driver.getTitle(),"CNN International - Breaking News, US News, World News and Video");
	   try {
		Thread.sleep(3000);
	   } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   driver.findElement(By.xpath("/html/body/div[5]/div/div/header/div/div[1]/div/div[2]/nav/ul/li[7]/a")).click();
	   //driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/div[1]/div/div[2]/nav/ul/li[7]/a")).click();
	   Assert.assertEquals(driver.getTitle(),"CNN Travel | Global Destinations, Tips & Video");
	   try {
			Thread.sleep(3000);
		   } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	   driver.quit();
	}

}
