package com.testing.training;

import org.testng.annotations.Test;

public class priorityexample {
	@Test
	public void testone()
	{
		System.out.println("This is test one.");
	}
	@Test (priority=1)
	public void testtwo()
	{
		System.out.println("This is test two.");
	}
	@Test (priority=2)
	public void testthree()
	{
		System.out.println("This is test three.");
	}
	@Test (priority=3)
	public void testfour()
	{
		System.out.println("This is test four.");
	}
}
