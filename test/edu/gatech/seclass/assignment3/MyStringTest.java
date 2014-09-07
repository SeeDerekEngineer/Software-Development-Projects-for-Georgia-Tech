package edu.gatech.seclass.assignment3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyStringTest {

	//Verify special characters, capital letters, and double vowels retain functionality of getVowels()
	@Test
	public void testGetVowels() {
		MyString tester = new MyString();
		tester.setString("Aall eEl's iIn@#4 ooIut");
		assertEquals("Output should read 'AaeEiIoIu'", "AaeEiIooIu", tester.getVowels());
			
	}
	
	//Verify index 1 corresponds to first character in string, end index is inclusive of substring
	@Test
	public void testGetSubstring() {
		MyString tester = new MyString();
		tester.setString("Swell Days");
		assertEquals("Output should read 'well Day'","well Day",tester.getSubstring(2,8));
	}

	//Verify index 1 corresponds to first character in string, double letters, spaces, capital letters, 
	//special characters retain functionality of indexOf()
	@Test
	public void testIndexOf() {
		MyString tester = new MyString();
		tester.setString("Aa #$% Mmm");
		assertEquals("Output should read '9'", 9, tester.indexOf('m'));
	}

	@Test
	public void testRemoveChar() {
		MyString tester = new MyString();
		tester.setString("Slaughter ssbunnies");
		tester.removeChar('s');
		assertEquals("Output should read 'laughter bunnie'","laughter bunnie",tester);
	}

	@Test
	public void testInvert() {
		MyString tester = new MyString();
		tester.setString("Aall eEl's iIn@#4 ooIut");
	}

}
