package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

class Setup {
    static WebDriver driver;

    static WebDriver setupchromebrowser()
    {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    static WebDriver setupedgebrowser()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    static WebDriver nobrowser() throws InterruptedException {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("alert('Get the correct browser from user')");
        Thread.sleep(10000);
        return driver;
    }
}

public class randompactice
{
    static WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void beforeopeningbrowser(String browser) throws InterruptedException {
    if (browser.equalsIgnoreCase("Chrome"))
    {
        driver = Setup.setupchromebrowser();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    else if (browser.equalsIgnoreCase("Edge"))
    {
     driver = Setup.setupedgebrowser();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    else
    {
        driver = Setup.nobrowser();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
}
    @Parameters("url")
    @Test
    public void openbrowserpage(String url) {
        driver.get(url);

    }

    @AfterTest
    public void afteropeningbrowser() {
        driver.quit();
    }
}
