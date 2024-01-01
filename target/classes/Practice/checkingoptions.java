import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class checkingoptions 
{
	WebDriver driver;
@Test
	public void check()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tathagata\\workspace\\SeleniumPOMFramework\\Driver\\chromedriver.exe");
		
		ChromeOptions op=new ChromeOptions();
		op.setAcceptInsecureCerts(true);
		op.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
		op.addArguments("disable-infobars");
		op.addArguments("--disable-notifications");
		driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/blog/locators-in-selenium-webdriver-with-examples/");
		
		
		driver.quit();
	}
}
