package Practice;

import org.openqa.selenium.WebDriver;

import basicutilities.baseclass;

public class tplink 
{
	static WebDriver driver;
public static WebDriver setup()
{
	driver=baseclass.chromeinitialization();
	return driver;
}
public static void openbrowser()
{
	driver.get("http://tplinkwifi.net/");
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void closebrowser()
{
	driver.quit();
}
public static void main(String args[])
{
	setup();
	openbrowser();
	tplink.closebrowser();
}
}
