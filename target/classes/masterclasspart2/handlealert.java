package masterclasspart2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handlealert {
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
	//js-java script
	public void handlejsalerts()
	{
     driver.get("https://www.rediff.com/");
     driver.findElement(By.xpath("//a[@class='mailicon']")).click();
     driver.findElement(By.id("login1")).sendKeys("Tathagatapal12@gmail.com");
     //this's for the alert popup
     driver.findElement(By.name("proceed")).click();
     //Implementing the wait incase the alert popup takes time to load so the wait is being implemented.
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     wait.until(ExpectedConditions.alertIsPresent());
     //Accepting the alert box
     Alert alt = driver.switchTo().alert();
     //Print the meesage that's displayed in the alert dialouge box
     System.out.println(alt.getText());
     alt.accept();
     driver.findElement(By.id("password")).sendKeys("Gogol");
     try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
