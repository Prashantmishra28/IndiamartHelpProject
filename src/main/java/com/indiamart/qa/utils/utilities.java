package com.indiamart.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utilities {
	
	public static final int Implicit_Wait_Time = 10;
	public static final int Page_Load_Time = 20;

	public static String generateRandomMobileNumber() {
			
		int[] StartDigit = {6,7,8,9};
		Random random = new Random();
			
		int firstDigit = StartDigit[random.nextInt(StartDigit.length)];
		StringBuilder mobileNumber = new StringBuilder();
		mobileNumber.append(firstDigit);
			for (int i = 0; i < 9; i++) {
				mobileNumber.append(random.nextInt(10));
			}
			
			return mobileNumber.toString();
		}
	
	public static String generateInvalidMobileNumber() {
		
		int[] StartDigit = {2,3,4,5};
		Random random = new Random();
			
		int firstDigit = StartDigit[random.nextInt(StartDigit.length)];
		StringBuilder mobileNumber = new StringBuilder();
		mobileNumber.append(firstDigit);
			for (int i = 0; i < 9; i++) {
				mobileNumber.append(random.nextInt(10));
			}
			
			return mobileNumber.toString();
		}
	
	
	public static Object[][] gettestdatafromexcel(String sheetname) {
	    Object[][] data = null;
	    XSSFWorkbook workbook = null;
	
	    try {
	        File excelfile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\indiamart\\qa\\testdata\\Indiamarttestdata.xlsx");
	        FileInputStream excelfis = new FileInputStream(excelfile);
	        workbook = new XSSFWorkbook(excelfis);
	        XSSFSheet sheet = workbook.getSheet(sheetname);
	        int rows = sheet.getLastRowNum(); 
	        int cols = sheet.getRow(0).getLastCellNum(); 
	
	        data = new Object[rows][cols];
	
	        for (int i = 0; i < rows; i++) {
	            XSSFRow row = sheet.getRow(i + 1);
	            for (int j = 0; j < cols; j++) {
	                XSSFCell cell = row.getCell(j);
	
	                if (cell == null) {
	                    data[i][j] = "";
	                }
	                switch (cell.getCellType()) {
	                    case STRING:
	                        data[i][j] = cell.getStringCellValue();
	                        break;
	                    case NUMERIC:
	                        if (DateUtil.isCellDateFormatted(cell)) {
	                            data[i][j] = cell.getDateCellValue().toString();
	                        }else {
	                            long numericValue = (long) cell.getNumericCellValue();
	                            data[i][j] = String.valueOf(numericValue);
	                            break;
	                        }
	                    case BOOLEAN:
	                        data[i][j] = String.valueOf(cell.getBooleanCellValue());
	                        break;
	                    case FORMULA:
	                        try {
	                            data[i][j] = cell.getStringCellValue();
	                        } catch (IllegalStateException e) {
	                            data[i][j] = String.valueOf(cell.getNumericCellValue());
	                        }
	                        break;
	                    case BLANK:
	                        data[i][j] = "";
	                        break;
	                    default:
	                        data[i][j] = "Unsupported Type";
	                        break;
	                }
	            }
	        }
	
	        workbook.close();
	        excelfis.close();
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	
	    return data;
	}
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+ testName +".png";
		
		try {
			FileHandler.copy(srcScreenshot,new File(screenshotpath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return screenshotpath;
	}
		
}


