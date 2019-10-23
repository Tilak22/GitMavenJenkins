package scripts;

import generic.FwUtils;
import generic.IautoConstants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

public class Practice01 implements IautoConstants
{
    @Test 
	public void writedate() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException 
	{
    	
		LocalDate ld = LocalDate.now();
		
		String d = ld.toString();
		System.out.println(d);
		LocalTime lt = LocalTime.now();
		String t = lt.toString();
		System.out.println(t);
		Thread.sleep(3000);
		String dt = d+t;
//		FwUtils.writeexcel(XLDATA, "Sheet1", 0, 0, d);
//		FwUtils.writeexcel(XLDATA, "Sheet1", 1, 0, t);
        FwUtils.writelastexcel(XLDATA, "Sheet1", 0, dt);
//        FwUtils.writelastexcel(XLDATA, "Sheet1", 0, t);
	}

}
