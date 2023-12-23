package deloittewebsiteautomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkapplication 
{
	ChromeDriver driver;
	String url="https://www2.deloitte.com/us/en.html";
	
	@BeforeMethod
	public void openurl()
	{
	 driver=(ChromeDriver)WebDriverManager.chromedriver().create();
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Parameters({"usename","password"})
	@Test
	public void select(String usename, String password)
	{
		
		WebElement alert=driver.findElement(By.id("onetrust-accept-btn-handler"));
		
		Element(alert);
		Assert.assertEquals(driver.getTitle(),"Deloitte US | Audit, Consulting, Advisory, and Tax Services");
		
		
		driver.findElement(By.xpath("//header/div[1]/div[4]/ul[1]/li[2]/a[1]")).click();
		
		driver.findElement(By.id("siteSearch")).sendKeys("India");
		
		WebElement element=driver.findElement(By.xpath("//span[text()='India (Offices of the US) (English)']"));
		
		Element(element);
		
		WebElement alert2=driver.findElement(By.xpath("//div[@class='banner-actions-container']//button[text()='Decline optional cookies']"));
		
		Element(alert2);
		
		WebElement careers=driver.findElement(By.xpath("//*[@data-sub='Careers']"));
		Actions action=new Actions(driver);
		action.moveToElement(careers).build().perform();
		driver.findElement(By.xpath("//*[text()='Job Search' and @target='_blank']")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> itr=windows.iterator();
		
		String mainpageid=itr.next();
		String nextpageid=itr.next();
		driver.switchTo().window(nextpageid);
		
		driver.findElement(By.xpath("//*[@class='nav__list nav__list--user']//a[@class='nav__item__link']")).click();
		driver.findElement(By.name("username")).sendKeys(usename);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("Login")).click();

	}
	
	public void Element(WebElement element)
	{
		if(element.isDisplayed())
		{
			element.click();
		}
	}
}
