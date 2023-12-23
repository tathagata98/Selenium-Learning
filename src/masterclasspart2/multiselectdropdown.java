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

public class multiselectdropdown {
WebDriver driver = null;
	
	@BeforeMethod
	public void setup()
	{
System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		//driver.findElement(By.linkText("English (UK)")).click();
		//driver.findElement(By.linkText("Sign Up")).click();
		//or we can use the following xpath link for Signup
		//driver.findElement(By.xpath("//div[@role='contentinfo']/ul/li[1]/a")).click();
		//or
		//driver.findElement(By.xpath("//div[@id='pageFooterChildren']/ul/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
	@Test
	public void selectmultiselectdropdown()
	{
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='iframeResult']")));
		//or
		driver.switchTo().frame("iframeResult");

		WebElement multiselect = driver.findElement(By.id("cars"));
		//or
		//WebElement multiselect = driver.findElement(By.name("cars"));
		Select select= new Select(multiselect);
		//is Multiple(Select class)
		System.out.println(select.isMultiple());
		//Selecting multiple values
		select.selectByIndex(1);
		select.selectByIndex(3);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//getfirstselectedoption (this just prints the first selected option
		System.out.println(select.getFirstSelectedOption().getText());
		System.out.println("****************************************");
		//getall selected options
		List<WebElement> mulselect = select.getAllSelectedOptions();
		for(WebElement mul : mulselect )
		{
			System.out.println(mul.getText());
		}
		select.deselectByIndex(1);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		select.deselectByValue("audi");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		select.selectByValue("opel");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		select.deselectByVisibleText("Opel");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		select.selectByIndex(1);
		select.selectByIndex(3);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		select.deselectAll();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
