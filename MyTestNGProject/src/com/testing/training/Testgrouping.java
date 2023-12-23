package com.testing.training;

import org.testng.annotations.Test;

public class Testgrouping {
	
@Test(groups="Regression")
public void testcaseone()
{
	System.out.println("I'm in this test case one and in the regression group");
}
@Test(groups="Regression")
public void testcasetwo()
{
	System.out.println("I'm in this test case two and in the regression group");
}
@Test(groups="Smoke Test")
public void testcasethree()
{
	System.out.println("I'm in this test case three and in the smoke test group");
}
@Test(groups= {"Regression","Sanity"})
public void testcasefour()
{
	System.out.println("I'm in this test case one and in the regression and sanity group");
}
}
