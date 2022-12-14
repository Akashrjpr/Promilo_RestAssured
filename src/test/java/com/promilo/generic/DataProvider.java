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
	@org.testng.annotations.DataProvider(name ="forgotPassword1")
	public String[][] forgotPassword1() throws EncryptedDocumentException, IOException {
		String[][] ar = new String[2][4];
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				ar[i][j] = TestData.getexceldata("Sheet1", i+19, j);
			}
		}
		return ar;
	}
	@org.testng.annotations.DataProvider(name ="forgotPassword2")
	public String[][] forgotPassword2() throws EncryptedDocumentException, IOException {
		String[][] ar = new String[2][4];
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				ar[i][j] = TestData.getexceldata("Sheet1", i+21, j);
			}
		}
		return ar;
	}
	@org.testng.annotations.DataProvider(name ="otp")
	public String[][] otp() throws EncryptedDocumentException, IOException {
		String[][] ar = new String[2][2];
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				ar[i][j] = TestData.getexceldata("Sheet1", i+25, j);
			}
		}
		return ar;
	}
	@org.testng.annotations.DataProvider(name ="invite")
	public String[][] invite() throws EncryptedDocumentException, IOException {
		String[][] ar = new String[2][1];
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				ar[i][j] = TestData.getexceldata("Sheet1", i+51, j);
			}
		}
		return ar;
	}
	@org.testng.annotations.DataProvider(name ="verifyOTP")
	public String[][] verifyOTP() throws EncryptedDocumentException, IOException {
		String[][] ar = new String[4][3];
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				ar[i][j] = TestData.getexceldata("Sheet1", i+56, j);
			}
		}
		return ar;
	}
	@org.testng.annotations.DataProvider(name ="login")
	public String[][] login1() throws EncryptedDocumentException, IOException {
		String[][] ar = new String[6][3];
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				ar[i][j] = TestData.getexceldata("Sheet1", i+61, j);
			}
		}
		return ar;
	}



}
