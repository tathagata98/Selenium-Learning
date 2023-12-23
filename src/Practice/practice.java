package Practice;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basicutilities.baseclass;
import basicutilities.testutil;

public class practice 
{
static WebDriver driver;
static Properties prop;
static int arr=1;
static WebDriverWait wait; 

public static void openbrowser()
{
	driver=baseclass.choosebrowserbypassingvalue("chrome");
}
public static void operation()
{
	
	driver.get("https://www.vixen.com/");
	
	driver.manage().timeouts().implicitlyWait(testutil.implicit_wait, TimeUnit.SECONDS);
	
	
	WebElement element=driver.findElement(By.xpath("//*[@href='/videos/24-hours']"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
	
    element.click();
    
    
	wait=new WebDriverWait(driver,testutil.explicit_wait);

    wait.until(ExpectedConditions.titleIs("24 Hours: VIXEN"));
    
    
    try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	baseclass.takescreenshot(arr++);
    driver.navigate().back();
    

}
public static void closebrowser()
{
	driver.quit();
}


public static void main(String args[])throws Exception
{
	practice.openbrowser();
	practice.operation();
    practice.closebrowser();
   
}
}
