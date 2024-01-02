package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class webelements {
	//@Test
	public void findElements()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
	    WebDriver driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.actitime.com/");
	    driver.findElement(By.linkText("Try Free")).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.urlToBe("https://www.actitime.com/free-online-trial"));
	    driver.findElement(By.id("first-name")).sendKeys("Tathagata");
	    driver.findElement(By.id("last-name")).sendKeys("Pal");
	    driver.findElement(By.id("email")).sendKeys("tathagatapal12@gmail.com");
	    driver.findElement(By.id("company")).sendKeys("Gogol");
	    try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.quit();
	}

}	