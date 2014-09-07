package edu.gatech.seclass.assignment3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyStringTest {

	//Verify special characters, capital letters, punctuation, and double vowels retain functionality of getVowels()
	@Test
	public void testGetVowels() {
		MyString tester = new MyString();
		tester.setString("Aall eEl's iIn@#4 ooIut");
		assertEquals("Output should read 'AaeEiIoIu'", "AaeEiIooIu", tester.getVowels());
			
	}
	
	//Verify a String without vowels will return exception
	@Test(expected = RuntimeException.class)
	public void testGetVowels2() {
		MyString tester = new MyString();
		tester.setString("Spy Try Gym Rhythm");
		tester.getVowels();	
	}
	
	//Verify null string returns exception
	@Test(expected = NullPointerException.class)
	public void testGetVowels3() {
		MyString tester = new MyString();
		tester.setString(null);
		tester.getVowels();
	}
	
	//Verify empty string will return exception
	@Test(expected = RuntimeException.class)
	public void testGetVowels4() {
		MyString tester = new MyString();
		tester.setString("");
		tester.getVowels();
	}
	
	//Verify index 1 corresponds to first character in string, end index is inclusive of substring
	@Test
	public void testGetSubstring() {
		MyString tester = new MyString();
		tester.setString("Swell Days");
		assertEquals("Output should read 'well Day'","well Day",tester.getSubstring(2,8));
	}

	//Verify index too high will generate exception
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testGetSubstring2() {
		MyString tester = new MyString();
		tester.setString("Swell Days");
		tester.getSubstring(2,15);
	}
	
	//Verify index too low will generate exception
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testGetSubstring3() {
		MyString tester = new MyString();
		tester.setString("Swell Days");
		tester.getSubstring(-2,4);
		}
	
	//Verify empty string returns exception
	@Test(expected = RuntimeException.class)
	public void testGetSubstring4() {
		MyString tester = new MyString();
		tester.setString("");
		tester.getSubstring(1,2);
	}
	
	//Verify null string returns exception
	@Test(expected = NullPointerException.class)
	public void testGetSubstring5() {
		MyString tester = new MyString();
		tester.setString(null);
		tester.getSubstring(2,4);
	}	
	
	//Verify index 1 corresponds to first character in string 
	//Verify double letters, spaces, capital letters, punctuation, and special characters retain functionality of indexOf()
	@Test
	public void testIndexOf() {
		MyString tester = new MyString();
		tester.setString("A,a #$% Mmm");
		assertEquals("Output should read '10'", 10, tester.indexOf('m'));
	}

	//Verify a character not in the string returns exception
	@Test(expected = IllegalArgumentException.class)
	public void testIndexOf2(){
		MyString tester = new MyString();
		tester.setString("Aa #$% Mmm");
		tester.indexOf('d');
	}
	
	//Verify an empty string will yield exception
	@Test(expected = IllegalArgumentException.class)
	public void testIndexOf3(){
		MyString tester = new MyString();
		tester.setString("");
		tester.indexOf('d');
	}
	
	//Verify null string returns exception
	@Test(expected = NullPointerException.class)
	public void testIndexOf4() {
		MyString tester = new MyString();
		tester.setString(null);
		tester.indexOf('d');
	}	
	
	//Verify both upper and lower case letters are removed from string
	@Test
	public void testRemoveChar() {
		MyString tester = new MyString();
		tester.setString("Slaughter ssbunnies");
		tester.removeChar('s');
		assertEquals("Output should read 'laughter bunnie'","laughter bunnie",tester.getString());
		MyString tester2 = new MyString();
		tester2.setString("Slaughter ssbunnies");
		tester2.removeChar('S');
		assertEquals("Output should read 'laughter bunnie'","laughter bunnie",tester2.getString());
	}

	//Verify an input character not in the string throws an exception
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveChar2() {
		MyString tester = new MyString();
		tester.setString("Slaughter ssbunnies");
		tester.removeChar('m');
	}
	
	//Verify spaces and punctuation are removed from string
	@Test
	public void testRemoveChar3() {
		MyString tester = new MyString();
		tester.setString("S words for 500, Pat.");
		tester.removeChar(' ');
		tester.removeChar(',');
		tester.removeChar('.');
		assertEquals("Output should read 'Swordsfor500Pat'","Swordsfor500Pat",tester.getString());
	}
	
	//Verify null string returns exception
	@Test(expected = NullPointerException.class)
	public void testRemoveChar4() {
		MyString tester = new MyString();
		tester.setString(null);
		tester.removeChar('c');
	}	
	
	//Verify functionality of testInvert() with spaces, punctuation, and special characters
	@Test
	public void testInvert() {
		MyString tester = new MyString();
		tester.setString("?siht daer% uoy naC4");
		tester.invert();
		assertEquals("Output should read '4Can you %read this?'","4Can you %read this?",tester.getString());
	}

	//Verify null string returns exception
	@Test(expected = NullPointerException.class)
	public void testInvert2() {
		MyString tester = new MyString();
		tester.setString(null);
		tester.invert();
	}

	//Verify empty string returns empty string
	@Test
	public void testInvert3() {
		MyString tester = new MyString();
		tester.setString("");
		tester.invert();
		assertEquals("No output expected","",tester.getString());
	}
}
