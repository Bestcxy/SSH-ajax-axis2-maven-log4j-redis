package com.bestcxx.mavenstu.mavenssh.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.bestcxx.mavenstu.mavenssh.util.EnumUtil;

/**
 * 
 * @theme 操作 excel 文件的工具类
 * @author wujie
 * @Datetime 2017年3月24日 下午2:52:10
 */
public class FileOfficeExcel {
	private static Logger logger=LogManager.getLogger(FileOfficeExcel.class);
	public void readOfficeExcelFile(String excelPath,String excelName) {
		try {
			
			File file = new File(excelPath, excelName);

			// 文件转化为输入流
			FileInputStream fi;

			fi = new FileInputStream(file);

			// 操作excel文件需要创建Workbook 对象
			Workbook wb;

			wb = WorkbookFactory.create(fi);

			// 获得具体的一个sheet页-这里是第一个 
			Sheet sheet = wb.getSheetAt(0);

			// 获取最后一行的行号
			int rowNum = sheet.getLastRowNum() + 1;//这里加1，是因为获取的是序数值，而函数是从0开始计数的
			//logger.info("\n获取第一个 sheet 包含行数为:"+rowNum);
			
			// 获取某一行的数据-这里是第i行
			for(int i=2;i<rowNum;i++){
				Row row = sheet.getRow(i);
				// 获取某一行的列数
				int cellNum = row.getLastCellNum();
				logger.info("\n 第"+i+"行 包含列数为:"+cellNum);
				//输出这一句就可以看到，A1,B1,   A2,B2,C2,D2,E2
				//logger.info("\n行信息："+row.toString());
				
				//遍历行 
				for(int j=0;j<cellNum;j++){
					Cell cell=row.getCell(j);
					cell.setCellType(Cell.CELL_TYPE_STRING);//将表格数据格式转化为字符类型
					System.out.println(cell.getStringCellValue()+" ");					
				}
				
			}
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			logger.info(e1.toString());
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			logger.info(e.toString());
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			logger.info(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info(e.toString());
		}
		
	}

	public void writeOfficeExcelFile() {

	}

}
