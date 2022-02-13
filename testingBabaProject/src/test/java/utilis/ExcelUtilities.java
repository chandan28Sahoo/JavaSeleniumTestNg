package utilis;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public  ExcelUtilities(String excelPath, int sheetNo){
		try {
			wb = new XSSFWorkbook(excelPath);
			sheet = wb.getSheetAt(sheetNo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public String[][] getPostdata()
	{
		String[][] dataStrings;
		try 
		{
			DataFormatter formatter = new DataFormatter();
			int noOfRow = sheet.getPhysicalNumberOfRows();
			System.out.println(noOfRow);
			
			int noOfColumn = sheet.getRow(0).getLastCellNum() - 2;
			dataStrings = new String[noOfRow - 1][noOfColumn]; // given string size
			for (int i = 0; i < noOfRow -1; i++) {
				for (int j = 0; j < noOfColumn; j++) {
					dataStrings[i][j] = formatter.formatCellValue(sheet.getRow(i+1).getCell(j));
				}
			}
			return dataStrings;
		} catch (Exception e){
			System.out.println("Issue in Getread data "+e.getMessage());
			return null;
		}
	
	}
	public String[][] getUpdateData()
	{
		try 
		{
			DataFormatter formatter = new DataFormatter();
			int noOfRow = sheet.getPhysicalNumberOfRows();			
			int noOfColumn = sheet.getRow(0).getLastCellNum() - 2;
			String[][] dataStrings = new String[noOfRow - 1][noOfColumn]; // given string size
			for (int i = 0; i < noOfRow -1; i++) {
				for (int j = 0; j < noOfColumn; j++) {
					dataStrings[i][j] = formatter.formatCellValue(sheet.getRow(i+1).getCell(j + 2));
				}
			}
			return dataStrings;
		} catch (Exception e){
			System.out.println("Issue in Getread data "+e.getMessage());
			return null;
		}
	}
	public  void getrowcount()
	{
		try {
			int count=sheet.getPhysicalNumberOfRows();
			System.out.println(count);
		} catch (Exception e) {
			System.out.println("Issue in Getrow count "+e.getMessage());
		}
	}
	
}
