package edu.gatech.seclass.assignment3;

public class MyString implements MyStringInterface{
	
	private String current= "";
	
	// Sets the value of the current string.
    public void setString(String str){
    	current = str;
    }

    // Returns the current string.
    public String getString(){
    	return current;
    }

    // Returns a string that consists of all and only the vowels in the current string.
    // Only letters a, e, i, o, and u (both lower and upper case) are considered vowels.
    // The returned string contains each occurrence of a vowel in the current string.
    public String getVowels(){
    	String vowels = current;
		int i =0;
		char testchar = 'c';
		while (i < vowels.length()){
				testchar = vowels.charAt(i);
				if (testchar != 'A' && testchar != 'a' && 
				testchar != 'E' && testchar != 'e' &&
				testchar != 'I' && testchar != 'i' &&
				testchar != 'O' && testchar != 'o' &&
				testchar != 'U' && testchar != 'u'){
					String testchar2 = String.valueOf(testchar);
					vowels=vowels.replace(testchar2, "");
				}
				else {i++;}
	}
		if (vowels.length()==0){
			throw new RuntimeException("String contains no vowels.");
		}
		else {return vowels;}
    }

    // Returns a string that consists of the substring between start and end indexes (both included) in the current string.
    // Index 1 corresponds to the first character in the current string.
    public String getSubstring(int start, int end){
    	if (current.length() ==0){
    		throw new RuntimeException("Cannot make a substring from an empty string");
    	}
    	else {return current.substring(start -1, end +1);}
    }

    // Returns the index of the first occurrence of a character in the current string.
    // Index 1 corresponds to the first character in the current string.    
    public int indexOf(char c){
    	String testchar = String.valueOf(c);
    	if (!current.contains(testchar)){
    		throw new IllegalArgumentException("This character is not in this string");
    	}
    	else {return (current.indexOf(c)+1);}			
  }
    // Removes all occurrences of the specified character from the current string.
    public void removeChar(char c){
    	String testchara = String.valueOf(c);
    	if (current.toUpperCase().contains(testchara) || 
    		current.toLowerCase().contains(testchara)){
    		current = current.replace(testchara.toLowerCase(),"");
    		current = current.replace(testchara.toUpperCase(), "");
    	}
    	else {
    		throw new IllegalArgumentException("This character is not in the String.");
    	}
    }

    // Invert the current string.
    public void invert(){   
    	StringBuilder build = new StringBuilder(current);
    	current =new String(build.reverse());
    }
}
