package testngpreparation;

import org.testng.annotations.Test;

public class grouping 
{
	@Test(groups="Me")
public void display1()
{
	System.out.println("I am Tathagata");
}
	@Test(groups="Me")
public void display2()
{
	System.out.println("I live in Kolkata");
}
	@Test(groups="")
public void display3()
{
	System.out.println("I studied at St.Augustine's Day School");
}
	@Test(groups="Me")
public void display4()
{
	System.out.println("I want to move to Hyderabad");
}
	@Test(groups="Bullshit")
public void display5()
{
	System.out.println("I hate Priyanka Nandi");
}

}
