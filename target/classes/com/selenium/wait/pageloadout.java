package com.selenium.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	public class pageloadout {
		@Test
		public void pageloadtimeouttest()
		{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			//To maximize the browser
			driver.manage().window().maximize();
			//Define Page Load and Timeout
			//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.get("https://edition.cnn.com/");
			driver.quit();  
		}

	}

