package edu.gatech.seclass.assignment7;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyClassTestSC1 {

	@Test
	public void testBuggymethod1() {
		MyClass tester = new MyClass();
		assertEquals("Output should read '4'",4,tester.buggymethod1(4));
	}

}
