package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.time.Duration;

public class check {

    static WebDriver driver;

    public static WebDriver setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void i_am_on_ebay_home_page() {
        driver.get("https://www.ebay.com/");
    }

    public void i_click_on_advanced_link() {
        driver.findElement(By.xpath("//*[text()='Advanced']")).click();
    }

    public void i_navigate_to_the_advanced_search_page() {
    }

    public void quitbrowser() throws InterruptedException {
        JavascriptExecutor ob = (JavascriptExecutor) driver;
        ob.executeScript("alert('Closing browser we are good')");
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(10000);
        driver.quit();
    }

    public static void main(String args[]) throws Exception {
        setup();
        check ob = new check();
        ob.i_am_on_ebay_home_page();
        ob.i_click_on_advanced_link();
		ob.quitbrowser();
    }

}


