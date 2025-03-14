package com.api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviders {
	
	@DataProvider(name = "Users")
	public String[][] getAlluserdata() throws IOException{
		
		String path = System.getProperty("user.dir")+"\\TestData\\userTestdata.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rownum = xl.getRowCount("Sheet1");	
		int colcount = xl.getCellCount("Sheet1",1);
		
		String data[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for (int j=0;j<colcount;j++) {
				data[i-1][j] = xl.getCellData("Sheet1",i,j);
			}
		}
		
		return data;
		
	}
	
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException{
		
		String path = System.getProperty("user.dir")+"\\TestData\\userTestdata.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rownum = xl.getRowCount("Sheet1");
		
		String data[] = new String[rownum];
		
		for(int i=1;i<=rownum;i++) {
			data[i-1] = xl.getCellData("Sheet1",i,1);
			
		}
		
		return data;
	}
	
	@DataProvider(name = "StoreOrder")
	public String[][] getAllOrderdata() throws IOException{
		
		String path = System.getProperty("user.dir")+"\\TestData\\storeTestdata.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rownum = xl.getRowCount("Sheet1");	
		int colcount = xl.getCellCount("Sheet1",1);
		
		String data[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for (int j=0;j<colcount;j++) {
				data[i-1][j] = xl.getCellData("Sheet1",i,j);
			}
		}
		
		return data;
		
	}
	
	@DataProvider(name = "orderId")
	public String[] getOrderId() throws IOException{
		
		String path = System.getProperty("user.dir")+"\\\\TestData\\\\storeTestdata.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rownum = xl.getRowCount("Sheet1");
		
		String data[] = new String[rownum];
		
		for(int i=1;i<=rownum;i++) {
			data[i-1] = xl.getCellData("Sheet1",i,0);
			
		}
		
		return data;
	}
	

}
