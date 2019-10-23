package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class FwUtils extends BaseTest
{
 public static String readexcel(String path, String Sheet, int row,int cell) throws Exception 
 {
	 Workbook wb = WorkbookFactory.create(new FileInputStream(path));
	  Row r = wb.getSheet(Sheet).getRow(row);
	  if(r==null)
	  {
		  r=wb.getSheet(Sheet).createRow(row);
	  }
	 return r.getCell(cell, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
 }
 
 public static void writeexcel(String path,String Sheet,int row,int cell,String value) throws EncryptedDocumentException, FileNotFoundException, IOException
 {
	 Workbook wb = WorkbookFactory.create(new FileInputStream(path));
	 Row r = wb.getSheet(Sheet).getRow(row);
	  if(r==null)
	  {
		  r=wb.getSheet(Sheet).createRow(row);
	  }
	  
	  r.createCell(cell).setCellValue(value);
	  wb.write(new FileOutputStream(path));
 }
 public static void writelastexcel(String path,String Sheet,int cell,String value) throws EncryptedDocumentException, FileNotFoundException, IOException
 {
	 Workbook wb = WorkbookFactory.create(new FileInputStream(path));
	 int i = wb.getSheet(Sheet).getLastRowNum();
	// Row r = wb.getSheet(Sheet).getRow(i);
	System.out.println(i);
	  
		  Row r = wb.getSheet(Sheet).createRow(i+1);
	  
	  
	  r.createCell(cell).setCellValue(value);
	  wb.write(new FileOutputStream(path));
 }
 
 public void screenshot() throws IOException
 {
	 TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./photo/screenshot.png");
		
		FileUtils.copyFile(src, des);
		
 }
 
}
