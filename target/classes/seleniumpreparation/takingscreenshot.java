package seleniumpreparation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class takingscreenshot 
{
	WebDriver driver;
	@BeforeMethod
public void openbrowser()
{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\InterviewPreparationDeloitte\\Drivers\\chromedriver.exe");
	driver=new ChromeDriver();
		
	
	driver.get("https://www.vixen.com/");
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
	@Test
	public void capturescreenshot()
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destfile=new File("C:\\Users\\Tathagata\\workspace\\InterviewPreparationDeloitte\\src " + DateUtils.gettimestamp() + ".png");
		try {
			FileUtils.copyFile(srcFile,destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	
}
