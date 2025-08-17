package com.selenium.testng.script.demo;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataHandler {

	public static String[][] getTestData(String filename) {		
		
		XSSFWorkbook workbook;
		String[][] data = null;
		try {
			
			workbook = new XSSFWorkbook("./data/"+filename+".xlsx");
			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getPhysicalNumberOfRows();
			int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			
			data = new String[rowCount-1][columnCount];
			
			for (int i = 1; i < rowCount; i++) {
				for (int j = 0; j < columnCount; j++) {
					data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

}