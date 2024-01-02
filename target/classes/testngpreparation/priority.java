package testngpreparation;

import org.testng.annotations.Test;

public class priority 
{
	@Test(priority='1')
public void checkingexecution()
{
	System.out.println("This line is to be printed second");
}
	@Test
public void checking()
{
	System.out.println("Print first");
}
}
