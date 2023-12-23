package com.data.drivenframework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.data.drivenframework.utils.DateUtils;
import com.data.drivenframework.utils.ExtentReportManager;

public class BaseUI {

	public WebDriver driver;
	public Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	SoftAssert softAssert= new SoftAssert();
	/***************To invoke the browser*****************/
	public void invokebrowser(String browsername) 
	{
		try
		{
		if (browsername.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
					"//src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
					"//src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		}
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//ObjectReprository//ProjectConfig.properties");
			    prop.load(file); 
			} catch (Exception e) {
				reportFail(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	/***************To open the URL*****************/
	public void openURL(String websiteURLKey)
	{
		try
		{
		driver.get(prop.getProperty(websiteURLKey));
		reportPass(websiteURLKey + "Identified Succesfully");
	    }
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
    /***************To close the browser*****************/ 
	public void teardown()
	{
		driver.close();
	}
	/***************To quit the browser*****************/
	public void quitbrowser()
	{
		driver.quit();
	}
	/***************To pass the various web elements*****************/
	public void enterText(String pathKey, String data)
	{
		try 
		{
		getElement(pathKey).sendKeys(data);
	    reportPass(data + " Entered Successfully in locator Element" +pathKey); 
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());	
		}
	}
    /***************** To click the elements ***********************/ 
	public void elementclick(String pathKey) 
	{
		try {
		getElement(pathKey).click();
		reportPass(pathKey + " Entered Successfully in locator Element" +pathKey); 
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());	
		}
	}
	/***************** Verify the elements ***********************/
	public boolean isElementPresent(String locatorKey)
	{
		try
		{
			if(getElement(locatorKey).isDisplayed())
			{
			reportPass(locatorKey + ": element is displayed");	
			}
			return true;
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		return false;
	}
	public boolean isElementSelected(String locatorKey)
	{
		try
		{
			if(getElement(locatorKey).isSelected())
			{
			reportPass(locatorKey + ": element is selected");	
			}
			return true;
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		return false;
	}
	public boolean isElementEnabled(String locatorKey)
	{
		try
		{
			if(getElement(locatorKey).isEnabled())
			{
			reportPass(locatorKey + ": element is enabled");	
			}
			return true;
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		return false;
	}
	
	/***********************Identifying WebElements****************************/
	public WebElement getElement(String locatorKey)
	{
		WebElement element=null;
		try {
			
		if(locatorKey.endsWith("_id"))
		{
		element = driver.findElement(By.id(prop.getProperty(locatorKey)));
		logger.log(Status.INFO, "Locator Identified :" + locatorKey);
		}
		else if(locatorKey.endsWith("_CSS"))
		{
			element =driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
			logger.log(Status.INFO, "Locator Identified :" + locatorKey);
		}
		else if(locatorKey.endsWith("_linkText"))
		{
			element =driver.findElement(By.linkText(prop.getProperty(locatorKey)));
			logger.log(Status.INFO, "Locator Identified :" + locatorKey);
		}
		else if(locatorKey.endsWith("_name"))
		{
			element =driver.findElement(By.name(prop.getProperty(locatorKey)));
			logger.log(Status.INFO, "Locator Identified :" + locatorKey);
		}
		else if(locatorKey.endsWith("_partiallinkText"))
		{
			element =driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
			logger.log(Status.INFO, "Locator Identified :" + locatorKey);
		}
		else if(locatorKey.endsWith("_className"))
		{
			element =driver.findElement(By.className(prop.getProperty(locatorKey)));
			logger.log(Status.INFO, "Locator Identified :" + locatorKey);
		}
		else if(locatorKey.endsWith("_tagName"))
		{
			element =driver.findElement(By.tagName(prop.getProperty(locatorKey)));
			logger.log(Status.INFO, "Locator Identified :" + locatorKey);
		}
		else if(locatorKey.endsWith("_xpath"))
		{
			element =driver.findElement(By.xpath(prop.getProperty(locatorKey)));
			logger.log(Status.INFO, "Locator Identified :" + locatorKey);
		}
		else
		{
			reportFail("Failing the test case, Invalid locator " + locatorKey);
			
		}
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
			e.printStackTrace();
			
		}
		return element;
	}
	/***********************************Assertion Functions***********************************/
	public void assertTrue(boolean flag)
	{
		softAssert.assertTrue(flag);
	}
	public void assertFalse(boolean flag)
	{
		softAssert.assertFalse(flag);
	}
	public void assertEquals(String actual, String expected)
	{
		softAssert.assertEquals(actual,expected);
	}
	
	
    /***********************************Reporting functions***********************************/
	public void reportFail(String reportstring) 
	{
		logger.log(Status.FAIL, reportstring);
		takeScreenShotOnFailure();
		Assert.fail(reportstring);
	}
	public void reportPass(String reportstring)
	{
		logger.log(Status.PASS, reportstring);
	}
	@AfterMethod
	public void aftertest()
	{
		softAssert.assertAll();;
	}
	
	/***********************************Capturing screenshot***********************************/
    public void takeScreenShotOnFailure()
    {
    	TakesScreenshot takescreenshot = (TakesScreenshot) driver;
    	File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
    	File destfile=new File(System.getProperty("user.dir")+"/Screenshots/" + DateUtils.gettimestamp() + ".png");
        
    	try {
			FileUtils.copyFile(sourceFile, destfile);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"/Screenshots/" + DateUtils.gettimestamp() + ".png");
		}
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
