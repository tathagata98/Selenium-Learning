package com.testing.training;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Multitestdependancy {
	@Test
	public void start()
	{
     System.out.println("This is the start test");		
	}
	@Test(dependsOnMethods="start")
	public void process()
	{
     System.out.println("This is process test");		
	}
	@Test(dependsOnMethods="process")
	public void init()
	{
		Assert.assertTrue(false);
     System.out.println("This is the init test");		
	}
	@Test(dependsOnMethods={"process","init"})
	public void stop()
	{
     System.out.println("This is the stop test");		
	}

}
