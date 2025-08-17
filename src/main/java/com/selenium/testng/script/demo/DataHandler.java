package com.selenium.testng.script.demo;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHandler {

	public static void main(String[] args) throws InvalidFormatException, IOException {		
		
		XSSFWorkbook workbook = new XSSFWorkbook("./data/test-data.xlsx");
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(rowCount);
		System.out.println(columnCount);
		
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		
		workbook.close();

	}

}