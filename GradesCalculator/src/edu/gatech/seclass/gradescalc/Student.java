package edu.gatech.seclass.gradescalc;

public class Student {

	private String name;
	private String Gtid;
	private String email;
	private int C;
	private int CPlusPlus;
	private int java;
	private char jobExpected;
	private int attendance;
	private int[] grades;
	private int[] projectContribs;


	public Student(String yourName, String yourGTid, GradesDB yourDB) {
		this.name = yourName;
		this.Gtid = yourGTid;
		
	}
	
	public void setName(String newName){name = newName;} 
	public String getName(){ return name;}
	public void setGtid(String newGtid){Gtid = newGtid;}
	public String getGtid(){ return Gtid;}
	public void setEmail(String newEmail){email = newEmail;}
	public String getEmail(){ return email;}
	public int getC(){ return C;}
	public int getCPlusPlus(){ return CPlusPlus;}
	public int getJava(){ return java;}
	public char getJobExpected(){ return jobExpected;}
	public void setAttendance(int newAttendance){attendance = newAttendance;}
	public int getAttendance(){ return attendance;}
	public int[] getGrades(){ return grades;}
	public int[] getProjectContribs(){ return projectContribs;}
	
}