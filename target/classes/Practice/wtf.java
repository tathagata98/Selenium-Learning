package Practice;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.NetworkInterceptor;
import org.openqa.selenium.devtools.v120.network.model.Response;
import org.openqa.selenium.remote.http.Filter;
import org.openqa.selenium.remote.http.HttpResponse;

public class wtf
{

    public static void main (String[] args) throws InterruptedException {
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "E:\\SeleniumPracticeandLearn\\chromedriver.exe");

        driver = new ChromeDriver();

        Filter reportStatusCodes = next -> req -> {
            HttpResponse res;
            res = next.execute(req);
            System.out.printf("Request: %s -> Response: %s%n", req, res.getStatus());
            return res;
        };

        try (NetworkInterceptor ignore = new NetworkInterceptor(driver, reportStatusCodes)) {
            //driver.get("http://SeleniumHQ.com");
            driver.get("https://www.zomato.com/");

        }

        Thread.sleep(4000);

        driver.quit();
    }

}
