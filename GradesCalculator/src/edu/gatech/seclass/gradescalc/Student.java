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

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Gtid == null) ? 0 : Gtid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Gtid == null) {
			if (other.Gtid != null)
				return false;
		} else if (!Gtid.equals(other.Gtid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}