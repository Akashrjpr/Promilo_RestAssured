package com.promilo.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestData {
	
	public static String getexceldata(String sheet, int row, int cell ) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/API TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
		DataFormatter d = new DataFormatter();
		String value = d.formatCellValue(c);
		return value;
	}
	
	public static String getTestData(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Base_Data.txt");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
