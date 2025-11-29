package masterclasspart1;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class framehandling {



	public class explicitwait {
		
		WebDriver driver = null;
		
		@BeforeMethod
		public void setup()
		{
	
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\geckodriver.exe");
			
	                
			 driver = new FirefoxDriver();
			//To maximize the browser
			driver.manage().window().maximize();
			driver.get("https://jqueryui.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		@AfterMethod
		public void closeBrowser()
		{
			driver.quit();
		}
		@Test
		public void getIframe()
		{
			driver.findElement(By.linkText("Button")).click();
			WebElement pagetitle = driver.findElement(By.className("entry-title"));
			Assert.assertEquals(pagetitle.getText(), "Button");
			
			//Working inside I-frame
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
			//WebElement a = driver.findElement(By.xpath("//*[@class='widget']/button"));
			//or use another X-path
            WebElement b=driver.findElement(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']"));
			Assert.assertEquals(b.getText(), "A button element");
			//Assert.assertEquals(a.getText(), "A button element");
			
			//Working outside the frame
			driver.switchTo().parentFrame();
			WebElement bc=driver.findElement(By.xpath("//div[@class='demo-list']/h2"));
			Assert.assertEquals(bc.getText(),"Examples");
		}
		

}
}
