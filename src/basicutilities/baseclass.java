package basicutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class baseclass 
{
public  static WebDriver driver;

public static Properties prop;

/*You can go by this way also where in the actual class you need to write just
here you are just using the constructor of the class
public //classnamewhere it needs to be used()
{
	//super();
}
public static Properties baseclass()
{
	prop=new Properties();
	try {
		FileInputStream ip=new FileInputStream("F:\\workspace\\FirstSeleniumproject\\src\\configproperties\\config.properties");
        prop.load(ip);	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
}
*/
private static Properties propclass()
{
	prop=new Properties();
	try {
		FileInputStream ip=new FileInputStream("F:\\workspace\\FirstSeleniumproject\\src\\configproperties\\config.properties");
        prop.load(ip);	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
}

private static WebDriver localinitialize() 
{
	driver.manage().window().maximize();
	return driver;
}

public static WebDriver chromeinitialization()
{
WebDriverManager.chromedriver().forceDownload();
ChromeOptions options=new ChromeOptions();
options.addArguments("--disable-notifications");
options.addArguments("--disable-geolocation");
options.addArguments("--disable-media-stream");
driver=new ChromeDriver(options);
return baseclass.localinitialize();
}

public static WebDriver firefoxinitialization()
{
WebDriverManager.firefoxdriver().setup();
driver=new FirefoxDriver();
return baseclass.localinitialize();
}

public static WebDriver edgeinitialization()
{
WebDriverManager.edgedriver().setup();
driver=new EdgeDriver();
return baseclass.localinitialize();
}

/********When you want to open a browser from properties file**********/

public static WebDriver choosebrowserfrompropertiesfile()
{
	prop=baseclass.propclass();
	
	String browser=prop.getProperty("browser");
	
	if(browser.equalsIgnoreCase("chrome"))
	{
	driver= baseclass.chromeinitialization();
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		driver=baseclass.edgeinitialization();
	}
	else
	{
		driver=baseclass.firefoxinitialization();
	}
	
	return driver;
}

/********When you want to open a browser just by passing the browser name in method**********/

public static WebDriver choosebrowserbypassingvalue(String browser)
{
	
	if(browser.equalsIgnoreCase("chrome"))
	{
	driver= baseclass.chromeinitialization();
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		driver=baseclass.edgeinitialization();
	}
	else
	{
		driver=baseclass.firefoxinitialization();
	}
	
	return driver;
}

public static WebDriver returnurlfrompropfile()
{
	prop=baseclass.propclass();
	String url=prop.getProperty("url");
	if(url.startsWith("https:"))
	{	
		driver.get(url);	
	}
	else if((url.isEmpty()||(!url.startsWith("https:"))))
	{
		//driver.get("https://www.google.com");
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("alert('You have entered a wrong url/their is no URL, please kindly check');");

	}
	
	return driver;
}
public static void takescreenshot(int ar)
{
	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destfile=new File("Screenshots\\Screenshot"+ar+".png");
	try {
		FileUtils.copyFile(srcfile, destfile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ar++;	
}
public static void screenshotflush(int ar)
{
	if(ar!=0)
	{
	try
	{
		Files.deleteIfExists(Paths.get("Screenshots\\Screenshot"+ar+".png"));
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	}
}

}
