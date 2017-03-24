package com.bestcxx.mavenstu.mavenssh.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class FileOfficeExcelTest {
	private static Logger logger=LogManager.getLogger(FileOfficeExcelTest.class);
	
	@Test
	public void testReadOfficeExcelFile(){
		FileOfficeExcel f=new FileOfficeExcel();
		f.readOfficeExcelFile();
	}

}
