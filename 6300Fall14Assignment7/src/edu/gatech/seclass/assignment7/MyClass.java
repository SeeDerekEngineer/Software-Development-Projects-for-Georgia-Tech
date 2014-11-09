package edu.gatech.seclass.assignment7;

public class MyClass {

public int buggymethod1(int input){
		
		if (input != 3){
			System.out.println("True Statement");
		}
		return (input/(input-3));
	}
	
	public void buggymethod2(){
		System.out.println("not possible");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
