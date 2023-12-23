package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basicutilities.baseclass;

public class practiceanything 
{
	static WebDriver driver;
	public static  void openbrowser()
	{
	driver=baseclass.chromeinitialization();
	}
	public static void operation()
	{
		//driver.get("https://1337x.unblockit.click/home/");
		/*driver.get("https://www.bajaao.com/");
		driver.findElement(By.xpath("//*[@placeholder='Search Products']")).sendKeys("Amplifier");
		driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
		*/
		//driver.findElement(By.xpath("//*[@name='search']")).sendKeys("Friends");
		//driver.findElement(By.xpath("//*[@class='btn btn-search']")).submit();
	}
	public static void closebrowser()
	{
		driver.quit();
	}
	public static void main(String args[])throws Exception
	{
		practiceanything.openbrowser();
		practiceanything.operation();
		//practiceanything.closebrowser();
	}
}
