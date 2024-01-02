package Practice;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.RequestId;
import org.openqa.selenium.devtools.v120.network.model.Response;

import java.util.Optional;
import java.util.Set;

public class clearconsole {
    int i = 1;
    int j = 1;
    ChromeDriver driver;

    DevTools dev;

    Response response;

    //@BeforeClass
    public void openbrowser() {
        //driver= (ChromeDriver) baseclass.choosebrowserbypassingvalue("chrome");
        //driver=new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver","D:\\Selenium-Learning\\chromedriver.exe");

        //driver=new ChromeDriver();

    }

    //@Test
    public void clearConsoleErrors() {
        //move();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "console.clear();";
        js.executeScript(script);
        driver.manage().addCookie(new Cookie("profileid", "9999"));
        Set<Cookie> cookies = driver.manage().getCookies();
        String[] Cookie = cookies.toString().split(",");
        for (String print : Cookie)
            System.out.println(print);

        //driver.quit();
    }

    @Test
    public void move() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Learning\\chromedriver.exe");

        driver = new ChromeDriver();
        clearConsoleErrors();
        dev = driver.getDevTools();
        dev.createSession();
        dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

          /*  dev.addListener(Network.requestWillBeSent(),res->
                    {


                         request = res.getRequest();
                         if(request.getUrl().contains("php")) {
                             RequestId requestId[] = new RequestId[]{res.getRequestId()};
                             for (RequestId id : requestId) {
                                 //String payload = dev.send(Network.getRequestPostData(id)).toString();
                                 //String responses[] = new String[]{dev.send(Network.getResponseBody(id)).getBody()};
                            /*if (request.getUrl().contains("weatherstack"))
                            {
                                String method = request.getMethod();
                                System.out.println("URL'S:" + i + " :-" + request.getUrl() + " ===== METHODS:" + method );
                                urls.add(request.getUrl());
                                //String payload = dev.send(Network.getRequestPostData(id));
                                //int status = response.getStatus();
                                i++;
                            }
*/
                             /*
                                 String responses = dev.send(Network.getResponseBody(id)).toString();
                                 System.out.println("URL'S:" + j + " :-" + request.getUrl());
                                 System.out.println("RESPONSE " + j + " :-" + "=====" + responses);

                                 j++;
                             }
                         }

                    });

                            */

        dev.addListener(Network.responseReceived(), r ->
        {
            response = r.getResponse();
            if (response.getUrl().contains("?form")) {
                RequestId[] requestId = new RequestId[]{r.getRequestId()};
                System.out.println("The responses are : -");

                for (RequestId id : requestId) {
                    String responses = dev.send(Network.getResponseBody(id)).getBody();
                    System.out.println("URL :" + j + " :-" + response.getUrl());
                    System.out.println("STATUS CODE :" + j + " :-" + response.getStatus());
                    System.out.println("RESPONSE " + j + " :-" + "=====" + responses);
                    j++;
                }
            }
        });

        driver.get("https://www.flipkart.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver.findElement(By.xpath("//span[contains(text(),'Videos')]")).click();
    }

}
