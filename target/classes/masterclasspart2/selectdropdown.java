package masterclasspart2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class selectdropdown {
WebDriver driver = null;
	
	@BeforeMethod
	public void setup()
	{
System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("English (UK)")).click();
		//driver.findElement(By.linkText("Sign Up")).click();
		//or we can use the following xpath link for Signup
		//driver.findElement(By.xpath("//div[@role='contentinfo']/ul/li[1]/a")).click();
		//or
		driver.findElement(By.xpath("//div[@id='pageFooterChildren']/ul/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
	@Test
	public void selectDOB()
	{
		WebElement monthdropdown = driver.findElement(By.name("birthday_month"));
		Select select = new Select(monthdropdown);
		//Using select by index
		select.selectByIndex(5);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Using select by value
		select.selectByValue("11");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Using select by visible text
		select.selectByVisibleText("Sep");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//using select getoptions
		List<WebElement> mnthval = select.getOptions();
		for(WebElement mnth : mnthval)
		{
			System.out.println(mnth.getText());
		}
		
	}
	

}
