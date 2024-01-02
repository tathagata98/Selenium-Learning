package com.selenium.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class firstseleniumtest 
{
	@Test
	public void verifyAmazonHomePage()
	{
	String URL="https://www.amazon.in";
	
	//Open the URL with Selenium
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Tathagata\\workspace\\MyProject\\Drivers\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	//To maximize the browser
	driver.manage().window().maximize();
	driver.get(URL);
	
	//Verify Homepage Title
	
	String pagetitle = driver.getTitle();
	
	System.out.println("We get the title of the page :-" +pagetitle);
	
	Assert.assertEquals(pagetitle,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	
    driver.quit();
	
	}

}
