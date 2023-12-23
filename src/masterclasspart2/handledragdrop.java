package masterclasspart2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handledragdrop {
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
    //@Test
    public void drag()
    {
    	driver.get("https://jqueryui.com/");
    	driver.findElement(By.linkText("Draggable")).click();
    	driver.switchTo().frame(0);
    	WebElement drag = driver.findElement(By.id("draggable"));
    	Actions action =new Actions(driver);
    	action.dragAndDropBy(drag, 110, 120).build().perform();
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    //@Test
    public void dragnddrop()
    {
    	driver.get("https://jqueryui.com/");
    	driver.findElement(By.linkText("Droppable")).click();
    	driver.switchTo().frame(0);
    	WebElement drag = driver.findElement(By.id("draggable"));
    	WebElement drop = driver.findElement(By.id("droppable"));
    	Actions action =new Actions(driver);
    	action.dragAndDrop(drag, drop).build().perform();
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    @Test
    public void customdragnddrop()
    {
    	driver.get("https://jqueryui.com/");
    	driver.findElement(By.linkText("Droppable")).click();
    	driver.switchTo().frame(0);
    	WebElement drag = driver.findElement(By.id("draggable"));
    	WebElement drop = driver.findElement(By.id("droppable"));
    	Actions action =new Actions(driver);
    	action.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    

}
