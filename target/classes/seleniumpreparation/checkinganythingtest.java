package seleniumpreparation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basicutilities.baseclass;

public class checkinganythingtest 
{
	WebDriver driver;
@BeforeMethod
public void openbrowser()
{
    driver=baseclass.chromeinitialization();
	/*ChromeOptions co=new ChromeOptions();
	co.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
	driver=new ChromeDriver(co);
	*/
	driver.manage().window().maximize();
	driver.get("https://www.vixen.com/");
	
}
@Test
public void opentheselectedurl()
{
	WebElement url= driver.findElement(By.xpath("//*[@title='24 Hours' and @class]"));
	//File src= url.getScreenshotAs(OutputType.FILE);
	/*File destination=new File("F:\\workspace\\FirstSeleniumproject\\Screenshots" + DateUtils.gettimestamp() + ".png");
	try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/		
}
	
//@AfterMethod
/*public void closebrowser()
{
	driver.quit();
	
}
*/
}
