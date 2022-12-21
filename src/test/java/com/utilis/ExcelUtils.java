package com.utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static Object[][] readExcelData(String excelPath, String sheetName) throws IOException {

		Object[][] testData=null;
		
		File file=new File(excelPath);
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		int totalRows=sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Total Rows: " +totalRows+ " Total Columns: " +columns);
		
		testData=new Object[totalRows-1][columns];
		int ci,cj;
		ci=0;
		for(int i=1;i<=totalRows-1;i++,ci++) {
			cj=0;
			Row row=sheet.getRow(i);
			int totalCells=columns;
			
			for(int j=0;j<totalCells;j++,cj++) {
				Cell cel=row.getCell(j);
				
				if (cel.getCellType()==CellType.BLANK) {
					testData[ci][cj]="";
					System.out.println("");
				}
				if (cel.getCellType()==CellType.NUMERIC) {
					testData[ci][cj]=row.getCell(cj).getNumericCellValue();
					System.out.println(row.getCell(cj).getNumericCellValue());
				}
				else if (cel.getCellType()==CellType.BOOLEAN) {
					testData[ci][cj]=row.getCell(cj).getBooleanCellValue();
					System.out.println(row.getCell(cj).getBooleanCellValue());
				}
				else{
					testData[ci][cj]=row.getCell(cj).getStringCellValue();
					System.out.println(row.getCell(cj).getStringCellValue());
				}
			}
		}
		
		return testData;
		
	}
	public static void main(String[] args) throws IOException {
		String excelPath="C:\\Users\\ASJARE\\eclipse-workspace\\RestAssuredBddCucumber\\resources\\testdata\\GoogleMap_AddPlaceAPI.xlsx";
	    String excelSheet="postCall";
		ExcelUtils ex= new ExcelUtils();
		Object[][] obj=ExcelUtils.readExcelData(excelPath, excelSheet);
		System.out.println(obj.length);;
		
	}
}
