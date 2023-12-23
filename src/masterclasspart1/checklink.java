package masterclasspart1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class checklink {
	
	@Test
	public void extractlinkfromwebpage()
	{
/*System.setProperty("webdriver.chrome.driver","C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();*/
	

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tathagata\\workspace\\FirstSeleniumproject\\Drivers\\geckodriver.exe");
		
                
		 WebDriver driver = new FirefoxDriver();
		//To maximize the browser
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/blog/locators-in-selenium-webdriver-with-examples/");
		
		//Apply implicit wait
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links are :" +links.size());
		
		for (WebElement link : links)
		{
			//To print the various links present inside the webpage
			//System.out.println(link.getText());
			
			String url=link.getAttribute("href");
			getlinkstatus.verifyLink(url);
		}
		
		getlinkstatus.getInvalidLink();
		driver.quit();  
}
}
