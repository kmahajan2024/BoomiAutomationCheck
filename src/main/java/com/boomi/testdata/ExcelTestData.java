package com.boomi.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.boomi.base.BrowserLaunch;

/**
 * 
 * @author KMAHAJAN
 *
 */

public class ExcelTestData extends BrowserLaunch{
	//instance;
	//protected Properties prop; 
	
	String dir = System.getProperty("user.dir");
	public String[][] read(String... metainfo) throws Exception  
    {
			String data[][];
			@SuppressWarnings("resource")
			Workbook book = new XSSFWorkbook( new FileInputStream(
					new File(dir + prop.getProperty("excel_location"))));
			Sheet sheet = null;
			
			if(metainfo.length==0){
				sheet = book.getSheetAt(0);
			}
			else{
				sheet = book.getSheet(metainfo[0]);
			}
			
			int rowno = sheet.getLastRowNum();
			int column = sheet.getRow(0).getLastCellNum();
			data = new String[rowno+1][column];
			
			for(int i=0;i<rowno+1;i++){
				
				Row row = sheet.getRow(i);
				for(int j=0;j<row.getLastCellNum();j++){
					
					Cell cell = row.getCell(j);
					String cellValue = null;
					try {
						 cellValue = cell.getStringCellValue();
					} catch (Exception e) {

						 cellValue = String.valueOf(cell.getNumericCellValue());
					}
					
					data[i][j] =cellValue;
					
				}
				
			}
			//System.out.println(Arrays.toString(data));
             return data;
    }
		
	public String getValueOfColumn(String columnname, int index){
		String data[][]=null;
		try {
			data = this.read();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+index);
		//String column[] = data[0];
		int counter = 0;
		for(int i=0;i<data[0].length;i++){
			if(data[0][i].equals(columnname)){
				counter = i;
				break;
			}
		}
		//System.out.println("Data :"+  data[index][counter]);
		return data[index][counter];
	}
	
	public boolean setCellData(String colName, int rowNum, String data) {
		try {
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook( new FileInputStream(
					new File(dir + prop.getProperty("excel_location"))));
			
			Sheet sheet = null;

			if (rowNum <= 0)
				return false;

			/*int index = workbook.getSheetIndex("Sheet1");
			int colNum = -1;
			if (index == -1)
				return false;*/
			
			int colNum = 0;
			
			sheet = workbook.getSheetAt(0);

			Row row = sheet.getRow(0);
			for (int i = 0; i <= row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
					colNum = i;
					break;
				}
					
			}
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum);
			if (row == null)
				row = sheet.createRow(rowNum);

			Cell cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(data);

			FileOutputStream fileOut = new FileOutputStream(dir + prop.getProperty("excel_location"));

			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void colorRow(int rowNum, String color) {
		
		try {
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook( new FileInputStream(
					new File(dir + prop.getProperty("excel_location"))));
			
			Sheet sheet = workbook.getSheetAt(0);

			Row row = sheet.getRow(rowNum);
			CellStyle style = workbook.createCellStyle();
			Cell cell;
            
			for(int i = 0; i<=row.getLastCellNum(); i++) {
				if(color.equals("Orange")) {
					try {
						style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());  
						style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
						cell = row.getCell(i);
						if(cell != null) {
							cell.setCellStyle(style);
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				else if(color.equals("Yellow")) {
					try {
						style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());  
						style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
						cell = row.getCell(i);
						if(cell != null) {
							cell.setCellStyle(style);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				else if(color.equals("BlueGrey")) {
					try {
						style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());  
						style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
						cell = row.getCell(i);
						if(cell != null) {
							cell.setCellStyle(style);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				else if(color.equals("LightGrey")) {
					try {
						style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());  
						style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
						cell = row.getCell(i);
						if(cell != null) {
							cell.setCellStyle(style);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			FileOutputStream fileOut = new FileOutputStream(dir + prop.getProperty("excel_location"));

			workbook.write(fileOut);

			fileOut.close();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void renameSheet() {
		try {
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook( new FileInputStream(
					new File(dir + prop.getProperty("excel_location"))));
			
			Format dateFormat = new SimpleDateFormat("yyyyMMdd");
		    String currentDate = dateFormat.format(new Date());
		    //System.out.println(currentDate);
			
			Sheet sheet = null;
			
			sheet = workbook.getSheetAt(0);
			
			workbook.setSheetName(0, "Daily_Report_Status" + currentDate);
			
			FileOutputStream fileOut = new FileOutputStream(dir + prop.getProperty("excel_location"));

			workbook.write(fileOut);

			fileOut.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
