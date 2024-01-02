package Practice;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

		public class check {

		static WebDriver driver;
		public static WebDriver setup()
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		return driver;
		}
		
		public void i_am_on_ebay_home_page()
		{
			driver.get("https://www.ebay.com/");
		}

		public void i_click_on_advanced_link() {
		    driver.findElement(By.xpath("//*[text()='Advanced']")).click();
		}

		public void i_navigate_to_the_advanced_search_page() {
		}
		public static void main(String args[])throws Exception
		{
			setup();
			check ob=new check();
			ob.i_am_on_ebay_home_page();
			ob.i_click_on_advanced_link();
		}

	}


