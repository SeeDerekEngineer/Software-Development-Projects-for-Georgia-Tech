package edu.gatech.seclass.gradescalc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
	
	public GradesDB(String gradesDb) {
		
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

	public static String cellToString (HSSFCell cell) {
		
		int type = cell.getCellType();
		object result ;

		switch (type) {
		
			case 0 : //numerical value in excel
				result = cell.getNumbericCellValue();
				break;
			case 1: //String Value in excel
				result = cell.getStringCellValue();
				break;
			default:
				throw new RuntimeException(“Not an applicable cell content”);
		}
		return result.toString();
	} 

}
