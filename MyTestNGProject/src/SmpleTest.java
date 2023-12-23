import org.testng.annotations.*;

public class SmpleTest 
{
	@BeforeSuite
public void beforeSuiteMethod()
{
	System.out.println("Executing Before Test Suite");
}
	@AfterSuite
public void afterSuiteMethod()
{
	System.out.println("Executing After Test Suite");
}
}
