package com.selenium.wait;

import basicutilities.baseclass;
import basicutilities.testutil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class explicitWait {
	
	static WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
//System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		driver= baseclass.chromeinitialization();
		
		//driver.get("file:///C:/Users/Tathagata/Desktop/ExplicitWait.html");
		driver.get("http://tplinkwifi.net/");
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	@Test
	//First alert button test.
	public void verifyAlert()
	{
	driver.findElement(By.xpath("//button[@id='alert']")).click();
	WebDriverWait wait = new WebDriverWait(driver,testutil.explicit_wait);
	wait.until(ExpectedConditions.alertIsPresent());
	//This try catch block is implemented by me because it becomes very difficult to understand as the webpage
    //is closing very soon.
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.switchTo().alert().accept();
	//This try catch block is implemented by me because it becomes very difficult to understand as the webpage
	 //is closing very soon.
	}
	
	
	@Test(priority=2)
	//This test is for the display button after 10 seconds.
	public void verifyElementClickable()
	{
		driver.findElement(By.id("display-other-button")).click();
		WebElement b = driver.findElement(By.id("hidden"));
		WebDriverWait wait = new WebDriverWait(driver, testutil.explicit_wait);
		wait.until(ExpectedConditions.elementToBeClickable(b));
		//This try catch block is implemented by me because it becomes very difficult to understand as the webpage
		 //is closing very soon.
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=3)
	//Checkbox test case
	public void verifyElementSelected()
	{
	driver.findElement(By.id("checkbox")).click();
	//Using Webelement also we can do the following i.e "using id locator"
	//WebElement b = driver.findElement(By.id("ch"));
	WebDriverWait wait = new WebDriverWait(driver,testutil.explicit_wait);
	//wait.until(ExpectedConditions.elementToBeSelected(b));
	//wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.id("ch"))));
	wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@type='checkbox']")));
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Test(priority=1)
	//Selenium Webdriver Test
    public void verifyPresentText()
	{
		driver.findElement(By.id("populate-text")).click();
		WebDriverWait wait = new WebDriverWait(driver,testutil.explicit_wait);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//h2[@class='target-text']")), "Selenium Webdriver"));
		}	

}

