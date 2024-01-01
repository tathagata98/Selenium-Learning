package com.selenium.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class invokingdynamically
{
	    WebDriver driver=null;
	    @BeforeMethod
	    @Parameters("browser")
		
		public void invokebrowser(String browser)
		{
		if(browser.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else
		{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		}
		@AfterMethod
		public void quitbrowser()
		{
			driver.quit();
		}
		@Test
		public void verifyHomePage()
		{
		String URL="https://www.amazon.in";
		driver.get(URL);	
		//Verify Homepage Title
		
		String pagetitle = driver.getTitle();
		
		System.out.println("We get the title of the page :- " +pagetitle);
		
		Assert.assertEquals(pagetitle,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}



