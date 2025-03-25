package src.com.testing.training;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parameterxml 
{
	@Parameters("browser")
	@Test
	
	public void testcaseone(String browser)
	{
		System.out.println("The name of the browesr is :-" +browser);
	}
	
    @Parameters({"username","password"})
    @Test
    public void testcasetwo(String username,String password)
    {
    	System.out.println("The username is :-"+username);
    	System.out.println("The password for entering the browser is:-" +password);
    }
}
