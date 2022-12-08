package com.promilo.generic;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class DataProvider {
	
	@org.testng.annotations.DataProvider(name ="otpLogin")
	public String[][] otpLogin() throws EncryptedDocumentException, IOException {
		String[][] ar = new String[8][4];
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				ar[i][j] = TestData.getexceldata("Sheet1", i+30, j);
			}
		}
		return ar;
	}

	@org.testng.annotations.DataProvider(name ="activeStatus")
	public String[][] activeStatus() throws EncryptedDocumentException, IOException {
		String[][] ar = new String[5][4];
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				ar[i][j] = TestData.getexceldata("Sheet1", i+42, j);
			}
		}
		return ar;
	}


}
