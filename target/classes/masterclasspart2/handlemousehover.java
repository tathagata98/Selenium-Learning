package masterclasspart2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handlemousehover {
WebDriver driver = null;
	
	@BeforeMethod
	public void setup()
	{
System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
	@Test
    public void handlemousehover()
    {
	driver.get("https://www.americangolf.co.uk/");
	WebElement clothlink = driver.findElement(By.xpath("//*[@id=\"header-navigation\"]/div[1]/ul/li[3]/a"));
	Actions action=new Actions(driver);
	action.moveToElement(clothlink).build().perform();
	driver.findElement(By.xpath("//*[@id=\"CLOTHFOOTW_1\"]/ul/li[3]/ul/li[1]/a/span")).click();
	Assert.assertEquals("Golf Trousers | Ladies, Men's, Slim Fit Golf Trousers | American Golf", driver.getTitle());
    }
}
