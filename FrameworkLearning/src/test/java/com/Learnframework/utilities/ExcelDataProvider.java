/**
 * 
 */
package com.Learnframework.utilities;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author MD
 *
 */
public class ExcelDataProvider {
	
	/*Creating constructor*/
	
	XSSFWorkbook wb ; /* global var to access across proj*/
	public ExcelDataProvider()
	{
		File src = new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read excel file"+e.getMessage());
		
		}
		
	}
	
	public String getStringData(int sheetIndex,int row,int col)
	{
		return wb.getSheetAt(sheetIndex).getRow(0).getCell(0).getStringCellValue();
	}
	
	public String getStringData(String SheetName,int row,int col) /* Method Overloading- same method name n no of parameters but vaying datatype passed*/
	{
		return wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetName,int row,int col)
	{
		return wb.getSheet(sheetName).getRow(0).getCell(0).getNumericCellValue(); /* numbeic cell value retun double*/
	}

}
