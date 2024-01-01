package com.selenium.liveautomation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import basicutilities.baseclass;


public class Finalautomation
{
	WebDriver driver=null;
	@Test
	public void addstocks()
	{
	driver=baseclass.choosebrowserbypassingvalue("chrome");
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	//Open the Rediff
	driver.get("https://www.rediff.com/");
	
	//Click the money link
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
	
	//Click the sign-in link in the money page
	driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[1]")).click();
	
	//Enter the username
	driver.findElement(By.xpath("//*[@id=\"useremail\"]")).sendKeys("tathagatapal12@gmail.com");
	//Enter the password
	driver.findElement(By.xpath("//*[@id=\"userpass\"]")).sendKeys("tatha@1998");
	//Click the submit button
	//driver.findElement(By.xpath("//input[@value='Submit']")).click();
	//or
	driver.findElement(By.xpath("//input[@value='Submit']")).sendKeys(Keys.ENTER);
	
	//Selecting the portfolio
	WebElement dropdown = driver.findElement(By.id("portfolioid"));
	Select select = new Select(dropdown);
	select.selectByVisibleText("Test1");
	
	waitforpageload();
	
	//Add stocks
	driver.findElement(By.id("addStock")).click();
	driver.findElement(By.id("addstockname")).sendKeys("Nestle India Ltd");
	driver.findElement(By.xpath("//div[@id='ajax_listOfOptions']/div[1]")).click();
	
	//Selecting the calendar icon and clicking it.
	driver.findElement(By.id("stockPurchaseDate")).click();
	selectDateInCalendar("18/01/2020");
	
	//Adding the other parameters
	driver.findElement(By.id("addstockqty")).sendKeys("300");
	driver.findElement(By.id("addstockprice")).sendKeys("1500");
	driver.findElement(By.id("addStockButton")).click();
	
	waitforpageload();
	// Verify that the particular stock is being added or not
	
	int a=getStockRowNumber("Nestle India");
	System.out.println("Row number is :" +a);
	if(a==-1)
	{
		Assert.fail("Stock not found");
	}
	}
    @Test(dependsOnMethods="addstocks")
	public void deletestock()
	{
		int a=getStockRowNumber("Nestle India");
		driver.findElement(By.xpath("//table[@id='stock']/tbody/tr["+a+"]/td[1]")).click();
	    driver.findElements(By.xpath("//input[@name='Delete']")).get(a-1).click();
	    driver.switchTo().alert().accept();
	    driver.switchTo().defaultContent();
	    
	    waitforpageload();
	    
	    //Verify if the stock has been deleted or not
	    int stockRownumafterDelete = getStockRowNumber("Nestle India");
	    Assert.assertEquals(stockRownumafterDelete, -1, "Row is Deleted");
	    driver.quit();
	}
	public int getStockRowNumber(String stockname)
	{
		List<WebElement>totalrows=driver.findElements(By.xpath("//table[@id='stock']/tbody/tr"));
		int rownumber=1;
		for(WebElement row:totalrows)
		{
			List<WebElement>cellrows=row.findElements(By.tagName("td"));
			for(WebElement cell:cellrows)
			{
				String cellData=cell.getText();
			if(!cellData.isEmpty() && cellData.contains(stockname))	
			{
				//System.out.println("The stockname is :" +stockname);
				return rownumber;
				
			}
			}
			rownumber++;
			}
		return -1;
	}
	public void waitforpageload()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int i=0;
		while(i != 180)
		{
			String pagestate= (String) js.executeScript("return document.readyState;");
			if(pagestate.equals("complete"))
			{
				break;
			}
			else
			{
				waitload(1);
			}
		}
		waitload(2);
		i=0;
		while(i != 180)
		{
			Boolean jsstate= (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active ==0;");
			if(jsstate)
			{
				break;
			}
			else
			{
				waitload(1);
			}
		}
	}
	public void waitload(int i)
	{
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void selectDateInCalendar(String date)
	{
		// This date class in java finds the current date
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			Date expectedDate = dateFormat.parse(date);
			
			String day = new SimpleDateFormat("dd").format(expectedDate);
			String month = new SimpleDateFormat("MMMM").format(expectedDate);
			String year = new SimpleDateFormat("yyyy").format(expectedDate);
		
			String expectedMonthYear = month+ " " + year;
			
			while(true)
			{
				String displayDate = driver.findElement(By.className("dpTitleText")).getText();
				if(expectedMonthYear.equals(displayDate))
				{
					driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
					
					break;
				}
				else if(expectedDate.compareTo(currentDate) > 0)
				{
					driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
				}
				else
				{
					driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();
				}
				
			}
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
}

