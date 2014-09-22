package edu.gatech.seclass.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ASL {

	
	
	String delimiters = "[\\.!?]";
	File filepath;
	int average;
	int minimumLength = 4;
	int[] numberOfWords;
	int i = 0;
	int k = 0;
	int m = 0;
	int numberOfSentences = 0;
	int totalNumberOfWords = 0;
	String [] words;
	ArrayList<String> moreWords;
	Scanner in;
	
	
	    public void setMinWordLength(int yourMin){
			try {
					minimumLength = yourMin;
			    } catch (IllegalArgumentException e) {
			        System.err.println("Ensure the delimiters are: following the -d with a space, "
			        		+ "are in square brackets[], are valid delimiters");  
				}
			}
		
		
		public void setSentenceDelimiters(String yourdelims){
				try {
					delimiters = yourdelims;
			    } catch (IllegalArgumentException e) {
			        System.err.println("Ensure the delimiters are: following the -d with a space, "
			        		+ "are in square brackets[], are valid delimiters");  
			}
		}
		
		public void setFile(File yourfile){
			 filepath = yourfile;
			
		}
	
		public int computeAverageSentenceLength(){
		try{
		in = new Scanner(filepath);
		in.useDelimiter(delimiters);	
		while(in.hasNext()){
		String newSentence = in.next();
		if (!newSentence.equals("\"")){
				numberOfSentences++;
			}
		
		}
		
		numberOfWords = new int[numberOfSentences];
		
		in = new Scanner(filepath);
		in.useDelimiter(delimiters);	
		while(in.hasNext()){
		String newSentence = in.next();			//Make a new string sentence
		if (newSentence.contains("\"")){
			newSentence = newSentence.replace("\"", "");
			if(newSentence.length() == 0){
				continue;
			}
		}
		words = newSentence.trim().split("\\s+");		//Make an array of those words without spaces (so just the words)
		moreWords = new ArrayList(Arrays.asList(words));	//Make an arraylist of those words
		while (m<moreWords.size()){
				moreWords.set(m,moreWords.get(m).replaceAll("[^a-zA-Z]+",""));
			m++;
		}
		while (i<moreWords.size()){
		if(moreWords.get(i).length() < minimumLength)		//Go through each word, and if it is too small, remove it.
		{
			moreWords.remove(i);
		}
		else {i++;}
		}
		numberOfWords[k] = moreWords.size();
		k++;
    	i=0;
    	m=0;
		}
		for (int j : numberOfWords){
			totalNumberOfWords += j;
		}
		average = totalNumberOfWords/(numberOfWords.length);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		return average;
	}
	
}

