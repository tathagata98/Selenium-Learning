package seleniumpreparation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class takingscreenshotofspecificpart 
{
	WebDriver driver;
	@Test
	public void takescreenshot()
	{
		
		WebElement p=driver.findElement(By.xpath("//fieldset[@class='gra1'][1]"));
		File src= p.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\Tathagata\\workspace\\InterviewPreparationDeloitte\\Screenshots\\JavatPoint" + ".png");
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@BeforeMethod
public void openbrowser()
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\InterviewPreparationDeloitte\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.javatpoint.com/");
	
}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
}
