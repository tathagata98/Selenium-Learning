package com.data.drivenframework.test.LoginTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.data.drivenframework.base.BaseUI;

public class logintest extends BaseUI{
	
	
	@Test
	public void testOne()
	{
		
		logger=report.createTest("Enter the username and password");
		
		invokebrowser("chrome");
		
		openURL("websiteURL");
		
		elementclick("signinbtn_xpath");
		
		enterText("usernameTextbox_id","tathagatapal12@gmail.com");
		enterText("password_CSS","tatha@1998");
		
	}
	@AfterTest
	public void endReport()
	{
		report.flush();
	}
	@Test
	public void testTwo()
	{
		logger=report.createTest("Enter the correct username and password");
		invokebrowser("chrome");
		openURL("websiteURL");
		elementclick("signinbtn_xpath");
		enterText("usernameTextbox_xpath","tathagatapal12@gmail.com");
		
	}
	//@Test(dependsOnMethods="testTwo")
	public void testThree()
	{
		invokebrowser("chrome");
		openURL("websiteURL");
		elementclick("signinbtn_xpath");
		enterText("usernameTextbox_xpath","tathagatapal12@gmail.com");
		//enterusername("");
		//enterpassword("");
		quitbrowser();
	}
}
