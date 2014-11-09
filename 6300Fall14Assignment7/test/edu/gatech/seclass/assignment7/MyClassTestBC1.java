package edu.gatech.seclass.assignment7;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyClassTestBC1 {

	@Test
	public void testBuggymethod2() {
		MyClass tester = new MyClass();
		assertEquals("Output should read '4'",4,tester.buggymethod1(4));
	}

	@Test
	public void testBuggymethod3() {
		MyClass tester = new MyClass();
		assertEquals("Output should read '3/0'",3/0,tester.buggymethod1(3));
	}

	
}
