package com.selenium.webelement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Reddiffsignin {
	@Test
	public void testrediffsingintest()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Open the Rediff.com
        driver.get("https://www.rediff.com/");
        
        //Verify Page Title
        String pagetitle=driver.getTitle();
        Assert.assertEquals(pagetitle, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
        
        // Click Sign-in button
        // Here instead of using signinlink we could have named it something else too.
        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        signInLink.click();
        //Verify Sign-in Page title
        Assert.assertEquals(driver.getTitle(), "Rediffmail");
        
        //Insert userName and password
        WebElement username = driver.findElement(By.id("login1"));
        WebElement Password = driver.findElement(By.name("passwd"));
        username.sendKeys("tatha@98rediff.com");
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Password.sendKeys("test@123");
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //Click submit button
        WebElement gobutton = driver.findElement(By.name("proceed"));
        gobutton.click();
        
        //Verify the profile title
        Assert.assertEquals(driver.getTitle(), "Rediffmail");
        
        driver.quit();
	}

}
