package masterclasspart1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class extractspecificwebelements {
	WebDriver driver = null;
	
	@BeforeMethod
	public void setup()
	{
System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		//driver.get("https://edition.cnn.com/");
		driver.get("https://www.javatpoint.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
	@Test
	public void extractelements()
	{
		WebElement d=driver.findElement(By.xpath("//*[@id=\"footer\"]/footer[1]/div[1]"));
		List<WebElement> x = d.findElements(By.tagName("a"));
		System.out.println("Number of Learn tutorials section are : " +x.size());
		for (WebElement b : x )
			{
			String links = b.getText();
			if(!links.isEmpty())
			{
				System.out.println(links);
			}
		}
		
	}

}
