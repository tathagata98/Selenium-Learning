package com.testing.training;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class skippingexample {
	@Test
	public void testone()
	{
		System.out.println("This is test one.");
	}
	@Test (enabled=false)
	public void testtwo()
	{
		System.out.println("This is test two.");
	}
	@Test (priority=3)
	public void testthree()
	{
		System.out.println("This is test three.");
	}
	@Test (priority=2)
	
	public void testfour()
	{
		
		System.out.println("This is test four.");
		 throw new SkipException("Skipping deliberately");
	}
}
