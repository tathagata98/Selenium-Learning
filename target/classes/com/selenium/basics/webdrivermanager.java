package com.selenium.basics;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class webdrivermanager 
{
	@Test
public void main()
{
	
	ChromeDriver driver= (ChromeDriver)WebDriverManager.chromedriver().avoidShutdownHook().create();
	/*
	Capabilities cap=driver.getCapabilities();
	Map<String, Object> mycap=cap.asMap();
	System.out.print(mycap);
	*/
	driver.manage().window().maximize();
	driver.get("https://www.guru99.com/implicit-explicit-waits-selenium.html");

}
}
 