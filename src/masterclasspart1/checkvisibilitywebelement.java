package masterclasspart1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkvisibilitywebelement {
		
		WebDriver driver = null;
		
		@BeforeMethod
		public void setup()
		{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
			
			driver= new ChromeDriver();
			
			//To maximize the browser
			driver.manage().window().maximize();
			//driver.get("https://jqueryui.com/");
			driver.get("https://www.facebook.com/r.php");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		@AfterMethod
		public void closebrowser()
		{
			driver.quit();
		}
		//@Test
	    public void verifyElementdisplay()
	    {
			driver.findElement(By.linkText("Toggle")).click();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
			WebElement b= driver.findElement(By.xpath("//div[@id='effect']/h3"));
			//Assertion using and not using is almost the same.
			//Assert.assertTrue(b.isDisplayed());
			System.out.println("Display status of the toggle button inside the frame is:"+ b.isDisplayed());
	    }
		//@Test
		public void verifyElementenabled()
	    {
			WebElement c=driver.findElement(By.linkText("Resizable"));
			System.out.println("Link is enabled : "+ c.isEnabled());
	    }
		@Test
		public void verifyElementSelected()
		{
			WebElement a=driver.findElement(By.xpath("//input[@name='sex'  and @value='2']"));
			System.out.println("Female radio button status is :" +a.isSelected());
			a.click();
			System.out.println("Female radio button status is :" +a.isSelected());
		}
		

}
