package com.vtiger.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class FileUtility {
	/**
	 * This method is used to retrieve the data from poperty file
	 * @throws IOException 
	 * @author Raj Kumar Mahato
	 */
		
		public String getPropertyData(String key) throws IOException
		{
			FileInputStream fis = new FileInputStream("./src/test/resources/data/Commandata.property");			
					Properties p = new Properties();
			       p.load(fis);
			     String data = p.getProperty(key);
			     return data;
		}
		
		/**
		 * This method is used to retrieve the data from Excel sheet
		 * @throws IOException 
		 * @author Raj Kumar Mahato
		 */
		public String getExceldata(String sheet, int row, int cell) throws IOException
		{
			FileInputStream fis = new FileInputStream("./src/test/resources/data/AllData.xlsx");
			XSSFWorkbook xss = new XSSFWorkbook(fis);
			String data = xss.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			return data;
		}
}
