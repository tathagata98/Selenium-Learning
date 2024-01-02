package xpathmasterclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import basicutilities.baseclass;
public class xpath1 {
	WebDriver driver=null;
	@BeforeMethod
	public void main()
	{
		driver=baseclass.choosebrowserfrompropertiesfile();
	}
	@Test
	public void sendvalues()
	{
		driver.get("https://www.facebook.com/");
		/*
		driver.findElement(By.linkText("English (UK)")).click();
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("Ab");
		driver.findElement(By.xpath("//input[@aria-label='Surname']")).sendKeys("cd");
		driver.findElement(By.xpath("//input[@aria-required='true' and @aria-label='Mobile number or email address' ]")).sendKeys("tathagatapal12@gmail.com");
		driver.findElement(By.xpath("//label[text()='Female']"));
         */	
	}
	@AfterMethod
	public void browserclose()
	{
		driver.quit();
	}

}
