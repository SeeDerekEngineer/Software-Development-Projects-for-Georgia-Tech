package edu.gatech.seclass.gradescalc;

public class Student {

	private String name;
	private String Gtid;
	private String email;
	private int attendance;
	
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
	public void setAttendance(int yourAttendance){attendance = yourAttendance;}
	
	public int getAverageAssignmentsGrade(){
		GradesDB db = new GradesDB();
		return db.getAverageAssignmentsGrade(this);
	}
	
	public int getAverageProjectsGrade(){
		GradesDB db = new GradesDB();
		return db.getAverageProjectsGrade(this);
	}
	
	public int getTeam(){
		GradesDB db = new GradesDB();
		return db.getTeamNumber(this);
	}
	
	public int getAttendance(){
		GradesDB db = new GradesDB();
		return db.getAttendance(this);
	}
	
	
}