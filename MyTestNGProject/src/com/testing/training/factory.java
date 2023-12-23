package com.testing.training;

import org.testng.annotations.Factory;

public class factory {
	
@Factory
public Object[] getTestClass()
{
Object tests[]=new Object[2];
tests[0]=new testcase1();
tests[1]=new testcase2();
return tests;
}
}
