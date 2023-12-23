import org.testng.annotations.Test;

public class FacebookLogin {
    @Test
	public void loginwithvalidcredentials()
	{
		System.out.println("Hi,I'm successfully logged in");
		
	}
    @Test
	public void loginwithinvalidcredentials()
	{
		System.out.println("Hi,I'm unable to successfully logged in");
		
	}
    @Test
	public void loginwithvalidusername()
	{
		System.out.println("Hi,I'm successfully logged in with valid username");
		
	}
	
}
