package edu.gatech.seclass.gradescalc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GradesDB {

	private File excel;
	private FileInputStream fis;
	private FileOutputStream fos;
	private XSSFWorkbook wb;
	private XSSFSheet si;
	private XSSFSheet t;
	private XSSFSheet a;
	private XSSFSheet ig;
	private XSSFSheet ic;
	private XSSFSheet tg;
	static final String GRADES_DB = "DB" + File.separator
            + "GradesDatabase6300.xlsx";
	private String formula = "AT * 0.2 + AS * 0.4 + PR * 0.4";

	public void loadSpreadsheet(String gradesDb){
		excel = new File (gradesDb);
	}
	
	public int getNumAssignments(){
	
		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			ig = wb.getSheet("IndividualGrades");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
			
	
	int colNum = ig.getRow(0).getLastCellNum()-1;	      
	return colNum;
}

	public int getNumProjects(){
		
		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			tg = wb.getSheet("TeamGrades");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
			
	
	int colNum = tg.getRow(0).getLastCellNum()-1;	      
	return colNum;
}
	
	public int getNumStudents(){
		
		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			si = wb.getSheet("StudentsInfo");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
			
	
	int rowNum = si.getLastRowNum();	      
	return rowNum;
}
	public HashSet<Student> getStudents(){
		HashSet<Student> myStudents = new HashSet<Student>();
		
		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			si = wb.getSheet("StudentsInfo");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
		
		int rowNum = si.getLastRowNum();
		for (int i = 1; i < rowNum + 1; i++){
			Student student = new Student(" "," ", new GradesDB());
			XSSFRow row = si.getRow(i);
			XSSFCell cell = row.getCell(0);
			XSSFCell cell2 = row.getCell(1);
			student.setName(cellToString(cell));
			student.setGtid(cellToString(cell2));
			//Student student = new Student(cellToString(cell),cellToString(cell2), new GradesDB());
			myStudents.add(student);
			
			}
		
		return myStudents;
	}
	
	
	public Student getStudentByName(String name){
		
		Student studentByName = new Student(" ", " ", new GradesDB());
		studentByName.setName(name);
		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			si = wb.getSheet("StudentsInfo");	
			a = wb.getSheet("Attendance");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
		
		int rowNum = si.getLastRowNum();
		for (int i = 0; i < rowNum; i++){
			XSSFRow row = si.getRow(i);
			XSSFCell cell = row.getCell(0);
			if(cellToString(cell).equals(name)){
				XSSFCell cell2 = row.getCell(1);
				XSSFCell cell3 = row.getCell(2);
				studentByName.setGtid(cellToString(cell2));
				studentByName.setEmail(cellToString(cell3));
			}
		}
		int rowNum2 = a.getLastRowNum();
		for (int j =1; j < rowNum2; j++){
			XSSFRow arow = a.getRow(j);
			XSSFCell acell = arow.getCell(0);
			if(cellToString(acell).equals(name)){
				XSSFCell acell2 = arow.getCell(1);
				
				studentByName.setAttendance(Math.round(cellToInt(acell2)));
				
			}
		}
		studentByName.setTeam(getTeamNumber(studentByName));
		studentByName.setAverageAssignmentsGrade(getAverageAssignmentsGrade(studentByName));
		studentByName.setAverageProjectsGrade(getAverageProjectsGrade(studentByName));
		studentByName.setOverallGrade(getOverallGrade(studentByName));
		
		return studentByName;
	}
	
public Student getStudentByID(String id){
		
		Student studentById = new Student(" ", " ", new GradesDB());
		
		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			si = wb.getSheet("StudentsInfo");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
		
		int rowNum = si.getLastRowNum();
		for (int i = 0; i < rowNum; i++){
			XSSFRow row = si.getRow(i);
			XSSFCell cell = row.getCell(1);
			if(cellToString(cell).equals(id)){
				XSSFCell cell2 = row.getCell(0);
				
				studentById.setName(cellToString(cell2));
			}
		}
		return studentById;
	}
	
	public static String cellToString (XSSFCell cell) {
		
		
		int type = cell.getCellType();
		String result;

		switch (type) {
		
			case 0 : //numerical value in excel
				DataFormatter result1 = new DataFormatter();
				result = result1.formatCellValue(cell);
				break;
			case 1: //String Value in excel
				result = cell.getStringCellValue();
				break;
			case 3:
				result = "Blank";
				break;
			default:
				throw new RuntimeException("Not an applicable cell content");
		}
		return result;
		
	} 

	public static int cellToInt (XSSFCell cell) {
		
		int type = cell.getCellType();
		int result;

		switch (type) {
		
			case 0 : //numerical value in excel
				double result1 = cell.getNumericCellValue();
				result = (int) Math.round(result1);
				break;
			case 1: //String Value in excel
				throw new RuntimeException("Not a number");
			case 3: //Blank cell
				result = 0;
				break;
			default:
				throw new RuntimeException("Not an applicable cell content");
		}
		return result;
	} 
	
	// THIS IS THE START OF CODE NECESSARY FOR DELIVERABLE 2 //

	public int getTeamNumber(Student yourStudent){
		
		String nameOfStudent = yourStudent.getName();
		int teamNumber = 0;
		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			t = wb.getSheet("Teams");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
		
		int rowNum = t.getLastRowNum();
		int colNum = t.getRow(0).getLastCellNum()-1;
		for (int i = 1; i < rowNum + 1; i++){
			XSSFRow row = t.getRow(i);
			for (int j = 1; j < colNum + 1; j++){
				XSSFCell cell = row.getCell(j,t.getRow(i).CREATE_NULL_AS_BLANK);
				if(cellToString(cell).equals(nameOfStudent)){
					teamNumber = i;
				}
			}	
		}
		yourStudent.setTeam(teamNumber);
		return teamNumber;
	}
	
	public int getAverageAssignmentsGrade(Student yourStudent){
		
		String nameOfStudent=yourStudent.getName();
		double totalAssignmentPoints = 0;
		double average = 0;
		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			ig = wb.getSheet("IndividualGrades");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
		
		int rowNum = ig.getLastRowNum();
		int colNum = ig.getRow(0).getLastCellNum()-1;
		for (int i = 0; i < rowNum; i++){
			XSSFRow row = ig.getRow(i);
			XSSFCell cell = row.getCell(0);
			if(cellToString(cell).equals(nameOfStudent)){
				for (int j = 1; j < colNum + 1; j++){
					XSSFCell cell2 = row.getCell(j);
					totalAssignmentPoints = totalAssignmentPoints + cellToInt(cell2);
				}
				average = Math.round((totalAssignmentPoints/colNum));
			}	
		}
		yourStudent.setAverageAssignmentsGrade((int) average);
		return (int) average;
	}
	
public int getAverageProjectsGrade(Student yourStudent){
		
	String nameOfStudent=yourStudent.getName();
	double totalProjectPoints = 0;
	int projNum = 0;
	int[] projectGrades = null;
	int[] studentContributions = null;
	
	try {
		fis = new FileInputStream(excel);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		wb = new XSSFWorkbook(fis);	
		ic = wb.getSheet("IndividualContribs");
		tg = wb.getSheet("TeamGrades");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	      

	int cRowNum = ic.getLastRowNum();
	int colNum = ic.getRow(0).getLastCellNum()-1;
	for (int i = 0; i < cRowNum; i++){
		XSSFRow row = ic.getRow(i);
		XSSFCell cell = row.getCell(0,ic.getRow(i).CREATE_NULL_AS_BLANK);
		if(cellToString(cell).equals(nameOfStudent)){
			for (int m = 1; m < colNum + 1; m++){
				if(cellToString(row.getCell(m,ic.getRow(i).CREATE_NULL_AS_BLANK)) != "Blank"){
					projNum++;
				}
			}
			studentContributions = new int[projNum];
			projectGrades = new int[projNum];
			for (int j = 1; j < projNum + 1; j++){
				XSSFCell cell2 = row.getCell(j,ic.getRow(i).CREATE_NULL_AS_BLANK);
				studentContributions[j-1] = cellToInt(cell2);  //Student contributions are technically percentages so a factor of 100 will be removed before returning answer
			}
			break;
		}	
	}
	int teamRow = getTeamNumber(yourStudent);
	XSSFRow row = tg.getRow(teamRow);
	for (int j = 1; j < projNum + 1; j++){
				XSSFCell cell2 = row.getCell(j,tg.getRow(teamRow).CREATE_NULL_AS_BLANK);
				projectGrades[j-1] = cellToInt(cell2);
	}
	for (int k = 0; k < projNum; k++){
		totalProjectPoints = totalProjectPoints + studentContributions[k]*projectGrades[k];
	}
	System.out.println(projNum);
	yourStudent.setAverageProjectsGrade((int) Math.round(totalProjectPoints/projNum/100));
	return (int) Math.round(totalProjectPoints/projNum/100);  //Division by 100 takes contributions as percentages into account
	}


	public void addAssignment(String assignmentName){
		
		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			ig = wb.getSheet("IndividualGrades");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
		
		
		int colNum = ig.getRow(0).getLastCellNum();
		XSSFCell cell = ig.getRow(0).createCell(colNum);
		cell.setCellValue(assignmentName);

		try {
			fos = new FileOutputStream(excel);
			try {
				wb.write(fos);
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addGradesForAssignment(String assignmentName, HashMap<Student,Integer> grades){

		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			ig = wb.getSheet("IndividualGrades");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
		
		int rowNum = ig.getLastRowNum();
		int colNum = ig.getRow(0).getLastCellNum()-1;
		int assignmentIndex = -1;
		
		for (int i = 0; i< colNum + 1; i++){
			XSSFCell cell = ig.getRow(0).getCell(i,ig.getRow(0).CREATE_NULL_AS_BLANK);
			if(cellToString(cell).equals(assignmentName)){
				assignmentIndex = i;
				break;
			}
		}
		if (assignmentIndex == -1){throw new RuntimeException ("Assignment not found");}
		
		for(Student key : grades.keySet()){
			for (int j = 1; j < rowNum; j++){
			XSSFRow row = ig.getRow(j);
			XSSFCell cell = row.getCell(0);
			if(cellToString(cell).equals(key.getName())){
				XSSFCell cell2 = ig.getRow(j).createCell(colNum);
				cell2.setCellValue(grades.get(key));
			}
		}
		}
		

		try {
			fos = new FileOutputStream(excel);
			try {
				wb.write(fos);
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void addIndividualContributions(String projectName, HashMap<Student,Integer> contribs){

		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			ig = wb.getSheet("IndividualContribs");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
		
		int rowNum = ig.getLastRowNum();
		int colNum = ig.getRow(0).getLastCellNum();
		int assignmentIndex = -1;
		
		for (int i = 0; i< colNum; i++){
			XSSFCell cell = ig.getRow(0).getCell(i,ig.getRow(0).CREATE_NULL_AS_BLANK);
			if(cellToString(cell).equals(projectName)){
				assignmentIndex = i;
				break;
			}
		}
		if (assignmentIndex == -1){throw new RuntimeException ("Project not found");}
		
		for(Student key : contribs.keySet()){
			for (int j = 1; j < rowNum; j++){
				XSSFRow row = ig.getRow(j);
				XSSFCell cell = row.getCell(0,ig.getRow(j).CREATE_NULL_AS_BLANK);
				if(cellToString(cell).equals(key.getName())){
					XSSFCell cell2 = ig.getRow(j).createCell(assignmentIndex);
					cell2.setCellValue(contribs.get(key));
				}
			}
		}
		

		try {
			fos = new FileOutputStream(excel);
			try {
				wb.write(fos);
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//THIS IS THE START OF THE CODE NECESSARY FOR DELIVERABLE 3//

	/*public int getAttendance(Student yourStudent){
		
		String nameOfStudent=yourStudent.getName();
		int attendance = 0;
		try {
			fis = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);	
			a = wb.getSheet("Attendance");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
		
		int rowNum = a.getLastRowNum();
		for (int i = 0; i < rowNum; i++){
			XSSFRow row = a.getRow(i);
			XSSFCell cell = row.getCell(0);
			if(cellToString(cell).equals(nameOfStudent)){				
					XSSFCell cell2 = row.getCell(1);
					attendance = cellToInt(cell2);
			}	
		}
		return attendance;
	}*/
	
	public void setFormula(String newFormula){
		formula = newFormula;
	}
	
	public String getFormula(){
		return formula;
	}
	
	public int getOverallGrade(Student student) throws GradeFormulaException {
		
		double oGrade = 0;
		getFormula();
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        engine.put("AT", student.getAttendance());
        engine.put("AS", student.getAverageAssignmentsGrade());
        engine.put("PR", student.getAverageProjectsGrade());
        try {
			oGrade = (double) (engine.eval(formula));
			
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			throw new GradeFormulaException("Incorrect Formula");
		}
    	return (int) Math.round(oGrade);
	}
}

