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
    	return current;
    }

    // Returns a string that consists of the substring between start and end indexes (both included) in the current string.
    // Index 1 corresponds to the first character in the current string.
    public String getSubstring(int start, int end){
    	return current.substring(start -1,end -1);
    }

    // Returns the index of the first occurrence of a character in the current string.
    // Index 1 corresponds to the first character in the current string.    
    public int indexOf(char c){
    	return current.indexOf(c);
    }
    // Removes all occurrences of the specified character from the current string.
    public void removeChar(char c){
    	current = current.replace("c","");
    }

    // Invert the current string.
    public void invert(){   
    	StringBuilder build = new StringBuilder(current);
    	build.reverse();
    }
}
