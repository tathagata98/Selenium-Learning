package Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.DevToolsException;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.RequestId;
import org.openqa.selenium.devtools.v120.network.model.Response;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.Set;


public class clearconsole {
    int i = 1;
    int j = 1;
    static ChromeDriver driver;

    static DevTools dev;

    Response response;



    public void clearConsoleErrors() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "console.clear();";
        js.executeScript(script);
    }
    public void addcookies()
    {
        System.out.println("The cookies are :- ");
        driver.manage().addCookie(new Cookie("profileid", "9999"));
        Set<Cookie> cookies = driver.manage().getCookies();
        String[] Cookie = cookies.toString().split(",");
        for (String print : Cookie)
            System.out.println(" Cookie Details :-"+print);

    }
    public WebDriver requestdetails(String value) {
        dev = driver.getDevTools();
        dev.createSession();
        dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        dev.addListener(Network.responseReceived(), r ->
        {
            response = r.getResponse();
            if ((response.getUrl().endsWith(value)))
            {
                RequestId[] requestId = new RequestId[]{r.getRequestId()};

                for (RequestId id : requestId) {
                    String responses = null;
                    try {
                        responses = dev.send(Network.getResponseBody(id)).getBody();
                    } catch (DevToolsException e)
                    {
                        e.printStackTrace();
                    }
                    //String payload = dev.send(Network.getRequestPostData(id));
                    System.out.println("URL :" + j + " :-" + response.getUrl());
                    System.out.println("STATUS CODE :" + j + " :-" + response.getStatus());
                    //System.out.println("PAYLOAD" + j + " :-" + "=====" + payload);
                    System.out.println("RESPONSE " + j + " :-" + "=====" + responses);
                    j++;
                }
            }
        });
        return driver;
    }
    @Test
    public void move(){
        System.setProperty("webdriver.chrome.driver", "E:\\SeleniumPracticeandLearn\\chromedriver.exe");

        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        System.out.println("The responses are : -");

        requestdetails("quickLinks");
        clearConsoleErrors();
        driver.get("https://www.zomato.com/");
        addcookies();
        requestdetails("check-auth");
        driver.findElement(By.xpath("//a[contains(text(),'Add restaurant')]")).click();

    }

}
