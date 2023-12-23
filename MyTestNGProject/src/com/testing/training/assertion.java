package com.testing.training;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertion
{

	SoftAssert soft_assert = new SoftAssert();
	@Test
	public void softassert()
	{
		soft_assert.assertTrue(false);
		System.out.println("soft assertion");
	}
	@Test
	public void hardAssert()
	{
		Assert.assertTrue(false);
		System.out.println("Hard Assertion");
	}
	@Test
	public void hardassert()
	{
		Assert.assertTrue(true);
		System.out.println("Hard Assertion");
	}
	
}
