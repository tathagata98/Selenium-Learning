package com.testing.training;

import org.testng.annotations.Test;

public class Sampletest {
	@Test()
	public void test()
	{
		System.out.println("This is a valid test case");
	}
    @Test
    public void nottest()
    {
    	System.out.println("This is a not a valid test case");
    }
    //This test will not run because the test is enabled false,so this leaves the test case with not running.
    @Test(enabled=false)
    public void failtestcase()
    {
    	System.out.println("This method executes a failed test case");
    }
}
