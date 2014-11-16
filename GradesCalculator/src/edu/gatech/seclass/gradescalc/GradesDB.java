package edu.gatech.seclass.gradescalc;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GradesDB {


	File excel = new file (“C:\Users\Derek\git\6300Falldthayer6\GradesCalculator\DB”);
	FileInputStream fis = new FileInputStream(excel);
	HSSFWorkbook wb = new HSSFWorkbook(fis);	       //Workbook
	
	
	HSSFSheet ws = wb.getSheet(“Sheet1”);		       //Worksheet
	int rowNum = ws.getLastRowNum() + 1;		       //Row.   Java starts at 0, excel starts at 1, so add 1
	int colNum = ws.getRow(0).getLastCellNum();	       //Get the number of columns filled (java starts at 1)
	String [][] data = new String [rowNum][colNum];	   //Store the values

	for (int i = 0 ; I < rowNum; i++){
		HSSFRow row = ws.getRow(i);
			for (int j = 0; j < colNum ; j++){
				HSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				data[i][j] = value;
			}
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
