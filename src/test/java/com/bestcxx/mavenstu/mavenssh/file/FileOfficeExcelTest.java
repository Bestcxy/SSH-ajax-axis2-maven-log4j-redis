package com.bestcxx.mavenstu.mavenssh.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bestcxx.mavenstu.mavenssh.util.EnumUtil;

public class FileOfficeExcelTest {
	private static Logger logger=LogManager.getLogger(FileOfficeExcelTest.class);
	
	@Test
	//@Ignore
	public void testReadOfficeExcelFile(){
		FileOfficeExcel f=new FileOfficeExcel();
		//excel 所在文件夹
		String excelPath = EnumUtil.FILE_OFFICE_EXCEL_PATH.toString();
		
		//excel 名称
		String excelName = EnumUtil.FILE_OFFICE_EXCEL_NAME.toString();
		
		f.readOfficeExcelFile(excelPath,excelName);
	}

}
