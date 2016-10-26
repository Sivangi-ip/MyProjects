package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static Object[][]data=null;
	public static Object[][] getdata()
	{
		try {
			FileInputStream fin= new FileInputStream(new File("C:\\Users\\Shivangi\\Desktop\\my.xlsx"));
			try {
				@SuppressWarnings("resource")
				XSSFWorkbook book = new XSSFWorkbook(fin);
				org.apache.poi.ss.usermodel.Sheet sheet= book.getSheetAt(0);
				int rows= sheet.getLastRowNum();
				data= new Object[rows][1];
				int count=0;
				for(int i=1;i<rows;i++){
					Row row= sheet.getRow(i);
					Iterator<org.apache.poi.ss.usermodel.Cell>cell = row.cellIterator();
					while(cell.hasNext()){
						org.apache.poi.ss.usermodel.Cell c= cell.next();
						data[i][count]= c.getStringCellValue();
						count++;
					}
					
				
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}

}