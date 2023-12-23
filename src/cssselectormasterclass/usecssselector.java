package cssselectormasterclass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import basicutilities.baseclass;

public class usecssselector 
{
	static WebDriver Driver;
	static Properties prop;
	
	public static void opendesiredbrowser()
	{
		Driver=baseclass.choosebrowserbypassingvalue("chrome");
		
	}
	public static void operation()
	{
		
		Driver=baseclass.returnurlfrompropfile();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public static void closebrowser()
	{
		Driver.quit();
	}
	
public static void main(String args[])throws Exception
{
	usecssselector.opendesiredbrowser();
	usecssselector.operation();
	usecssselector.closebrowser();
}
}
