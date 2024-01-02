package seleniumpreparation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class takingscreenshotusingjava 
{
	static WebDriver driver;
	public void capturescreenshot()
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destfile=new File("E:\\workspace\\InterviewPreparationDeloitte\\Screenshots\\ "  + DateUtils.gettimestamp() + ".png");
		try {
			FileUtils.copyFile(srcFile,destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[])throws IOException
	{
		System.setProperty("webdriver.chrome.driver","E:\\workspace\\InterviewPreparationDeloitte\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
			driver.manage().window().maximize();
		
		driver.get("https://www.levi.in/");
		WebElement p=driver.findElement(By.id("dialog-container"));
		if(p.isDisplayed())
		{
			driver.findElement(By.className("close-popup-button")).click();
		}
		takingscreenshotusingjava ob=new takingscreenshotusingjava();
		ob.capturescreenshot();
	}
}
