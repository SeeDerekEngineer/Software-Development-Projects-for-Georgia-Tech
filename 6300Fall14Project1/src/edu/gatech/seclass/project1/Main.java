package edu.gatech.seclass.project1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String delimiters = "[\\.!?]";
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
    	try {
    		for (int d = 0; d<args.length; d++){
    			if (args[d].equals("-l")){
    				try {
    					minimumLength = Integer.parseInt(args[d+1]);
    			    } catch (NumberFormatException e) {
    			        System.err.println("Argument " + args[d+1] + " must be an integer{2,3,4,5,etc.}");
    			}
    		}
    		}
    		for (int f = 0; f<args.length; f++){
    			if (args[f].equals("-d")){
    				try {
    					delimiters = (args[f+1]);
    			    } catch (IllegalArgumentException e) {
    			        System.err.println("Ensure the delimiters are: following the -d with a space, "
    			        		+ "are in square brackets[], are valid delimiters");  
    			}
    		}
    		}
    		in = new Scanner(new File(args[0]));
			in.useDelimiter(delimiters);	
			while(in.hasNext()){
			String newSentence = in.next();
			if (!newSentence.equals("\"")){
					numberOfSentences++;
				}
			
			}
			numberOfWords = new int[numberOfSentences];
			
			in = new Scanner(new File(args[0]));
			in.useDelimiter(delimiters);	
			while(in.hasNext()){
			String newSentence = in.next();			//Make a new string sentence
			if (newSentence.contains("\"")){
				newSentence = newSentence.replace("\"", "");
				if(newSentence.length() == 0){
					continue;
				}
			}
			System.out.println(newSentence);
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
			System.out.println(moreWords.size());
	    	i=0;
	    	m=0;
			}
			for (int j : numberOfWords){
				totalNumberOfWords += j;
			}
			System.out.println(numberOfSentences);
			System.out.println(totalNumberOfWords);
			System.out.println(totalNumberOfWords/(numberOfWords.length));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
	}


