package Practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basicutilities.baseclass;

public class testpractice 
{
	WebDriver driver;
@BeforeClass
void entry()
{
	driver=baseclass.chromeinitialization();
}
@Test
void openbrowser()
{
	driver.get("https://1337x.unblockit.rsvp/home/");
}
@Test(priority=2)
void openurl()
{
	driver.get("https://www.jiocinema.com/");
}
@AfterClass
void exit()
{
	driver.quit();
}
}
