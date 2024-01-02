package com.selenium.liveautomation;

import java.util.concurrent.TimeUnit;

import basicutilities.testutil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class verify {
WebDriver driver = null;
	
	@BeforeSuite
	public void setup()
	{
System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	/*@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}*/
    @Test(priority=1)
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
        WebDriverWait wait = new WebDriverWait(driver, testutil.explicit_wait);
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("createPortfolio")));
    	driver.findElement(By.id("createPortfolio")).click();
    	driver.findElement(By.id("create")).clear();
    	driver.findElement(By.id("create")).sendKeys("Tatha");
    	driver.findElement(By.id("createPortfolioButton")).click();
    } 	
    @Test (priority=2)
    public void verification()
    {
    
     element("//*[@id='portfolioid']", "Tatha");	
    }
    @Test (priority=3)
    public void testdelete()
    {
    	driver.findElement(By.id("deletePortfolio")).click();
    	
    	driver.switchTo().alert().accept();
    	driver.switchTo().defaultContent();
    }
    public void element(String c, String value)
    {
    	int i=0;
    	while(i != 10)
    	{
    		WebElement p = driver.findElement(By.xpath(c));
    		Select select = new Select(p);
    		String pname = select.getFirstSelectedOption().getText();
    		if(pname.equalsIgnoreCase(value))
    		{
    			return;
    		}
    		else
    		{
    			try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			i++;
    		}
    	}
    	Assert.assertTrue(false, "The Given Text" +value + "is not present in Portfolio Dropdown");
    }
}
