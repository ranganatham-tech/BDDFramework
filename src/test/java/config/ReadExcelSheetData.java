package config;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheetData {

	public static void main (String [] args) throws IOException 
	{
		
		FileInputStream fs = new FileInputStream("./Test Data/Test Data.xlsx"); //Path of the Excel file
		
		XSSFWorkbook workbook = new XSSFWorkbook(fs); //Creating a Workbook
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		System.out.println("Valid Email and Password");
		
		Row r1 = sheet.getRow(0);
		Cell c1 = r1.getCell(0);
		System.out.println(c1); //Email
		
		Row r2= sheet.getRow(1);
		Cell c2 = r2.getCell(0);
		System.out.println(c2); //Email - Value

		System.out.println();
		
		Row r3 = sheet.getRow(0);
		Cell c3 = r3.getCell(1);
		System.out.println(c3); //Password
		
		Row r4 = sheet.getRow(1);
		Cell c4 = r4.getCell(1);
		System.out.println(c4); //Password - Value
		
		
		
		
		System.out.println("\n\nInvalid Email and Password");
		
		System.out.println(c1); //Email
		Row r5 = sheet.getRow(3);
		Cell c5 = r5.getCell(0);
		System.out.println(c5);
		
		System.out.println();
		
		System.out.println(c3); //Password
		Row r6 = sheet.getRow(3);
		Cell c6 = r6.getCell(1);
		System.out.println(c6);
		
		
		workbook.close();
	}
}
