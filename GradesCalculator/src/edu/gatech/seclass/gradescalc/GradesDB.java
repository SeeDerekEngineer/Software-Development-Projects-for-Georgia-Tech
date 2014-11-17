package edu.gatech.seclass.gradescalc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GradesDB {

	private File excel;
	private FileInputStream fis;
	private XSSFWorkbook wb;
	private XSSFSheet si;
	private XSSFSheet t;
	private XSSFSheet a;
	private XSSFSheet ig;
	private XSSFSheet ic;
	private XSSFSheet tg;
	
	public GradesDB(String gradesDb) {excel = new File (gradesDb);}
	
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
			
	
	int colNum = si.getLastRowNum();	      
	return colNum;
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
			Student student = new Student();
			XSSFRow row = si.getRow(i);
			XSSFCell cell = row.getCell(0);
			XSSFCell cell2 = row.getCell(1);
			student.setName(cellToString(cell));
			student.setGtid(cellToString(cell2));
			myStudents.add(student);
			}
		
		return myStudents;
	}
	
	
	public Student getStudentByName(String name){
		
		Student studentByName = new Student();
		
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
		
		int colNum = si.getLastRowNum();
		for (int i = 0; i < colNum; i++){
			XSSFRow row = si.getRow(i);
			XSSFCell cell = row.getCell(0);
			if(cellToString(cell).equals(name)){
				XSSFCell cell2 = row.getCell(1);
				
				studentByName.setGtid(cellToString(cell2));
			}
		}
		int colNum2 = a.getLastRowNum();
		for (int j =1; j < colNum2; j++){
			XSSFRow arow = a.getRow(j);
			XSSFCell acell = arow.getCell(0);
			if(cellToString(acell).equals(name)){
				XSSFCell acell2 = arow.getCell(1);
				
				studentByName.setAttendance(cellToInt(acell2));
				
			}
		}
		return studentByName;
	}
	
public Student getStudentByID(String id){
		
		Student studentById = new Student();
		
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
		
		int colNum = si.getLastRowNum();
		for (int i = 0; i < colNum; i++){
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
				result = (int) result1;
				break;
			case 1: //String Value in excel
				throw new RuntimeException("Not a number");
			default:
				throw new RuntimeException("Not an applicable cell content");
		}
		return result;
	} 
	
}