package com.mystore.dataProvider;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.mystore.Utility.NewExcelLibrary;

public class DataProviders 
{
	public static String[][] readData(String FileName) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wb=new XSSFWorkbook("./Data/TestData.xlsx");
		XSSFSheet ws = wb.getSheet("Credentials");
		int rowcount=ws.getLastRowNum();
		int cellcount=ws.getRow(1).getLastCellNum();
		String[][] data=new String[rowcount][cellcount];
		
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<cellcount;j++)
			{
		
		
		String text=ws.getRow(i).getCell(j).getStringCellValue();
		System.out.println(text);
		data[i-1][j]=text;
		
	} 
		}
		wb.close();
		return data;
		}
}