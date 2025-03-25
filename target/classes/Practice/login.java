package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


class setup {
    static WebDriver driver;

    static WebDriver setupbrowser() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}

public class login {

       /*//static WebDriver driver;
        public static void main(String args[]) throws InterruptedException {

            driver = setup.setupbrowser();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get("https://www.voyageeyewear.com/");
            //JavascriptExecutor ob = (JavascriptExecutor) driver;

            //ob.executeScript(driver.findElement(By.id("//*[@id='svgkp'][1]")).click());
            //ob.executeScript("document.getElementById('svgkp').click();");
            //Thread.sleep(20000);
            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='iframe-kp']")));
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='desktop_close_button']"))).click();
            //driver.findElement(By.xpath("//*[@id='close_button']")).click();
            driver.switchTo().parentFrame();
            driver.findElement(By.xpath("//*[@class='header--icon']")).click();
            //driver.quit();*/

}

//*[@id="loggedin-icons"]
