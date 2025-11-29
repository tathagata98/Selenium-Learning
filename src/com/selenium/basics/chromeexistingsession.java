package com.selenium.basics;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chromeexistingsession 
{
	
public static void main(String args[])
{
	Object o = null;
	ChromeDriver driver=null;
	// Simple way how to launch the chrome browser on a particular port
/*
	WebDriverManager.chromedriver().setup();
	ChromeOptions options=new ChromeOptions();
	//options.addArguments("--remote-allow-origins=*");
	options.setExperimentalOption("debuggerAddress","localhost:59610");
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
    driver.get("https://www.ebay.com/");
    
    */
    //chrome.exe --remote-debugging-port=59610 --user-data-dir=F:\Chromeport
	
	// Derive all the capabilities of the Chrome browser
	
	//Optimal way of launching chrome browser
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	Capabilities cap=driver.getCapabilities();
	//driver.quit();
	Set<String> myCap =cap.getCapabilityNames();
	System.out.println(myCap);
	if(myCap.contains("goog:chromeOptions"))
	o=cap.getCapability("goog:chromeOptions");
	String value=o.toString();
	System.out.println(value);
	int beginIndex=value.indexOf(":");
	int lastIndex =value.length();
	String w=(String) value.subSequence(beginIndex+1, lastIndex -1);
	System.out.println("Value of localhost for this session is : " +w);
	Process p = null;
	String cmdPortPass = "cmd /c start chrome.exe --remote-debugging-port=w --user-data-dir=F:\\Chromeport";
	try {
		
		p = Runtime.getRuntime().exec(cmdPortPass);

	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		p.waitFor();
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//driver.manage().window().maximize();
	
	}
	}


