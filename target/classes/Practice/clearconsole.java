package Practice;


import org.bouncycastle.cert.ocsp.Req;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.DevToolsException;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.LoaderId;
import org.openqa.selenium.devtools.v120.network.model.RequestId;
import org.openqa.selenium.devtools.v120.network.model.Response;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;


public class clearconsole {
    int i = 1;
    int j = 1;
    static String responses;
    static String payload;

    static ChromeDriver driver;

    static DevTools dev;
    static List<String> urls = new ArrayList<String>();
    Response response;


    public void clearConsoleErrors() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "console.clear();";
        js.executeScript(script);
    }

    public void addcookies() {
        driver.manage().addCookie(new Cookie("profileid", "9999"));
    }

    public void displaycookies() {
        System.out.println("The cookies are :- ");

        Set<Cookie> cookies = driver.manage().getCookies();
        String[] Cookie = cookies.toString().split(",");
        for (String print : Cookie)
            System.out.println(" Cookie Details :-" + print);

    }

    public void requestdetails(String value) {
        dev = driver.getDevTools();
        dev.createSession();
        dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        dev.addListener(Network.responseReceived(), r ->
        {
            response = r.getResponse();
            if ((response.getUrl().contains(value))) {

                String url = response.getUrl();
                RequestId[] requestId = new RequestId[]{r.getRequestId()};
                for (RequestId id : requestId) {

                    try {
                        payload = dev.send(Network.getRequestPostData(id));
                        responses = dev.send(Network.getResponseBody(id)).getBody();
                        System.out.println("URL :" + j + " :-" + url);
                        System.out.println("STATUS CODE :" + j + " :-" + response.getStatus());
                        System.out.println("PAYLOAD" + j + " :-" + "=====" + payload);
                        System.out.println("RESPONSE " + j + " :-" + "=====" + responses);
                        //System.out.println("RESPONSE " + j + " :-" + "=====" + responses.toString());
                    } catch (DevToolsException d) {
                        //payload = dev.send(Network.getRequestPostData(id));
                        //responses = dev.send(Network.getResponseBody(id)).getBody();
                        /*System.out.println("URL :" + j + " :-" + url);
                        System.out.println("STATUS CODE :" + j + " :-" + response.getStatus());
                        System.out.println("PAYLOAD" + j + " :-" + "=====" + "null");
                        System.out.println("RESPONSE " + j + " :-" + "=====" + responses);
                        System.out.println("RESPONSE " + j + " :-" + "=====" + responses.toString());
*/
                    }
                }
            }
            j++;
        });

        System.out.println("==================================  ");
    }

    @Test
    public void move() {
        System.setProperty("webdriver.chrome.driver", "E:\\SeleniumPracticeandLearn\\chromedriver.exe");

        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("The responses are : -");
        requestdetails("https://jumbo.zomato.com/event");
        clearConsoleErrors();
        driver.get("https://www.zomato.com/");
        addcookies();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        requestdetails("https://blog.zomato.com/api/fetch");
        driver.findElement(By.xpath("//a[contains(text(),'Investor Relations')]")).click();
        addcookies();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        displaycookies();
        driver.quit();
    }
}
