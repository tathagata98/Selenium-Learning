package masterclasspart3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handlewebtable {
WebDriver driver = null;
	
	@BeforeMethod
	public void setup()
	{
System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
    @Test
    public void managewebtable()
    {
    	driver.get("https://www.rediff.com/");
    	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
    	
    	driver.findElement(By.xpath("//*[@id=\"moremoney\"]/ul/li[3]/a")).click();
    	driver.findElement(By.xpath("//*[@id=\"showMoreLess\"]"));
    	
    	// Get Count rows
    	List<WebElement> r = driver.findElements(By.xpath("//*[@class='dataTable']//tbody/tr"));
    	System.out.println("Total no. of rows :" + r.size());
    	
    	//Get Count columns
    	List<WebElement> c = driver.findElements(By.xpath("//*[@class='dataTable']//tbody/tr[1]/td"));
    	System.out.println("Total no. of rows :" + c.size());
    	
    	//Get the data of a specific row
    	List<WebElement> rows = driver.findElements(By.xpath("//*[@class='dataTable']//tbody/tr[3]/td"));
    	System.out.println("*********** Data of 3rd Row *************");
    	for(WebElement row : rows)
    	{
    	System.out.print(row.getText());
    	}
    	System.out.println();
    	
    	//Get the data of a specific column
    	List<WebElement> columns = driver.findElements(By.xpath("//*[@class='dataTable']//tbody/tr/td[3]"));
    	System.out.println("*********** Data of 3rd Column *************");
    	for(WebElement col : columns)
    	{
    	System.out.println(col.getText());
    	}
    	System.out.println();
    	
    	//Print data of complete table
    	System.out.println("**********Complete Table data***********");
    	{
    		for(WebElement roww : r)
        	{
        	System.out.println(roww.getText());
        	}
        	System.out.println();
        	
    	}
    }
}
