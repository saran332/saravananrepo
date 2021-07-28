package com.sra.qa.TC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelupload {
	
	
	
	public excelupload(String username , String password) throws IOException {
		
	FileInputStream fis = new FileInputStream("C:\\Saran\\SRAauto\\Sra\\src\\main\\java\\com\\sra\\qa\\excel\\autotest.xlsx");
	
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	
	XSSFSheet sheet = wb.getSheetAt(0);
	
	XSSFRow row = sheet.getRow(0);
	
	XSSFCell cell = row.getCell(1);
	
	System.out.println(cell);
	
	wb.close();
	}
	

}
