package masterclasspart1;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class extractclassinselenium  {
		
		WebDriver driver;
		@Test
		public void extracttextfromwebpage()
		{
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\geckodriver.exe");
			
	         FirefoxOptions fo=new FirefoxOptions();
	         fo.setHeadless(true);
	         
			 driver = new FirefoxDriver(fo);
			
			//To maximize the browser
			//driver.manage().window().maximize();
			
			driver.get("https://www.amazon.in/");
			
			//Apply implicit wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String h = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).getText();
            System.out.println(h);
            Assert.assertEquals(h, "Hello, sign in");
            String i = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).getAttribute("aria-label");
            System.out.println(i);
            Assert.assertEquals(i, "Search");		
	        driver.quit();  

		}
		

	

}
