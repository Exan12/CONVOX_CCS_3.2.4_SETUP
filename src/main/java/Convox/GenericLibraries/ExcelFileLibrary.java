package Convox.GenericLibraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of all generic methods to read and write data in the Excel sheet
 * @author Mani
 *
 */
public class ExcelFileLibrary {
	
	/**
	 * This method is used to Read the data from the Excel Sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IconstantsLibrary.excelPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		String value = c.getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This method used to get the count of rows Present in the current sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IconstantsLibrary.excelPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		wb.close();
		return rowcount;
	}
	
	/**
	 * This methos is used to Write the data in the Excel Sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataToExcel(String sheetName,int rowNum,int cellNum,String value) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IconstantsLibrary.excelPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IconstantsLibrary.excelPATH);
		wb.write(fos);
		wb.close();
		System.out.println("Data written Succesfully");
	}
	
	/**
	 * This Method is used to fetch the Multiple data from the excel sheet in 2-D array and feed
	 * to the data Object
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleDataToExcel(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IconstantsLibrary.excelPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object [lastrow][lastcell];
		
		for(int i=0;i<=lastrow;i++)
		{
			for(int j=0;j<=lastcell;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
