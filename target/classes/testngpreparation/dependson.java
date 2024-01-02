package testngpreparation;

import org.testng.annotations.Test;

public class dependson 
{

@Test(groups="Test")
public void depend()
{
System.out.println("I am test one.");	
}
 
//This next method actually checks the dependency on the method name.
@Test(dependsOnMethods="depend")
public void execute()
{
System.out.println("I am dependent on test one.");
}

//This next method actually checks the dependency on the group name.
@Test(dependsOnGroups="Test")
public void checkgroupdependency()
{
System.out.println("I am dependent on group test : Test");
}

@Test(groups="Test")
public void checkwronggroupdependency()
{
System.out.println("I am dependent on group test : Test");
}

}
