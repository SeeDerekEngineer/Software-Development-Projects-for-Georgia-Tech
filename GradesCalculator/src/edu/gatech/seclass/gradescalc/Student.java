package edu.gatech.seclass.gradescalc;

public class Student {

	private String name;
	private String Gtid;
	private String email;
	private GradesDB db;
	private int teamNumber;
	private int attendance;
	private int averageAssignmentsGrade;
	private int averageProjectsGrade;
	private int overallGrade;
	
	
	public Student(String yourName, String yourGTid, GradesDB yourDB) {
		this.name = yourName;
		this.Gtid = yourGTid;
		this.db = yourDB;
		
	}
	
	public void setName(String newName){name = newName;} 
	public String getName(){ return name;}
	public void setGtid(String newGtid){Gtid = newGtid;}
	public String getGtid(){ return Gtid;}
	public void setEmail(String newEmail){email = newEmail;}
	public String getEmail(){ return email;}
	public void setAttendance(int yourAttendance){attendance = yourAttendance;}
	public int getAttendance(){return attendance;}
	public void setTeam(int newTeam){teamNumber = newTeam;}
	public int getTeam(){return teamNumber;}
	public void setAverageAssignmentsGrade(int newAGrade){averageAssignmentsGrade = newAGrade;}
	public int getAverageAssignmentsGrade() {return averageAssignmentsGrade;}
	public void setAverageProjectsGrade(int newPGrade){averageProjectsGrade = newPGrade;}
	public int getAverageProjectsGrade() {return averageProjectsGrade;}
	public void setOverallGrade(int newOGrade) {overallGrade = newOGrade;}
	public int getOverallGrade() {return overallGrade;}
	
	
}