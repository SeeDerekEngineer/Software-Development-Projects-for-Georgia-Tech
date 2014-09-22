package edu.gatech.seclass.project1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		ASL asl = new ASL();
		asl.setSentenceDelimiters("[\\.!?]");
		asl.setMinWordLength(4);
		asl.setFile(new File(args[0]));
		for (int f = 0; f<args.length; f++){
			if (args[f].equals("-d")){
				try {
					asl.setSentenceDelimiters(args[f+1]);
			    } catch (IllegalArgumentException e) {
			        System.err.println("Ensure the delimiters are: following the -d with a space, "
			        		+ "are in square brackets[], are valid delimiters");  
			    }	
			}
		}
		
		for (int d = 0; d<args.length; d++){
			if (args[d].equals("-l")){
				try {
					asl.setMinWordLength(Integer.parseInt(args[d+1]));
			    } catch (NumberFormatException e) {
			        System.err.println("Argument " + args[d+1] + " must be an integer{2,3,4,5,etc.}");
			    }
			}
		}
		System.out.println("The Average Number of words per sentence is " + asl.computeAverageSentenceLength());
	}
		
}

