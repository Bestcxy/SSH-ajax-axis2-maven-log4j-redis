package com.bestcxx.mavenstu.mavenssh.file;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
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
	
	/**
	 * 
	 * @instruction 读取excel文件
	 * @Datetime 2017年3月27日 下午3:59:15
	 * @param excelPath 文件夹路径
	 * @param excelName 文件名字  officeExcelDemo.xlsx 
	 */
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
			logger.info(e1.toString());
		} catch (EncryptedDocumentException e) {
			logger.info(e.toString());
		} catch (InvalidFormatException e) {
			logger.info(e.toString());
		} catch (IOException e) {
			logger.info(e.toString());
		}
		
	}

	
	/**
	 * 
	 * @instruction 在原先的excel文件续写-没有加末尾判断，可能会造成数据被覆盖
	 * @Datetime 2017年3月27日 下午6:25:26
	 * @param excelPath
	 * @param excelName
	 */
	public void writeOfficeExcelFile(String excelPath, String excelName) {
		Workbook wb;
		File file=new File(excelPath,excelName);
		String fileName=excelPath+"/"+excelName;
		try {
			wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			Row row=sheet.createRow(1);
			
			for (int i = 0; i < 10; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(i + "");
			}
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			OutputStream out = null;
			try {
				wb.write(os);
				byte[] xls = os.toByteArray();
				out = new FileOutputStream(file);
				out.write(xls);
			} catch (IOException e) {
				logger.info(e.toString());
			} finally {
				try {
					if(wb!=null){
						wb.close();					
					}
					if(out!=null){
						out.close();
					}
					if(os!=null){
						os.close();					
					}
					logger.info("新建文件 "+fileName);
				} catch (IOException e) {
					logger.info(e.toString());
				}

			}
			
		} catch (EncryptedDocumentException e) {
			logger.info(e.toString());
		} catch (InvalidFormatException e) {
			logger.info(e.toString());
		} catch (IOException e) {
			logger.info(e.toString());
		}  
         
        
         
         
         
	}
	
	/**
	 * 
	 * @instruction 程序新建一个excle文件，并且填充一些数据
	 * @Datetime 2017年3月27日 下午6:00:08
	 * @param excelPath
	 * @param excelName
	 */
	public void createOfficeExcelFile(String excelPath, String excelName) {
		//如果文件存在，就先删除
		String fileName=excelPath+"/"+excelName;
		File file = new File(excelPath,excelName);  
        if(file.exists()){    //文件存在
        	logger.info("文件已经存在，删除 "+fileName);
        	file.delete();
        }
		// 操作excel文件需要实例化 Workbook，借助poi
		Workbook wb = new HSSFWorkbook();

		// 设置字体格式-略 import org.apache.poi.ss.usermodel.Font;
		// Font font = wb.createFont();

		// 设置单元格样式-略 import org.apache.poi.ss.usermodel.CellStyle;
		// CellStyle style = wb.createCellStyle();

		// 新建工作表
		Sheet sheet = wb.createSheet("测试sheet1");// 创建工作表，名称为test

		// 新建行-第0行，从0开始计数
		Row row = sheet.createRow(0);

		// 给第0行添加数据
		for (int i = 0; i < 10; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(i + "");
			// 结合样式
			// cell.setCellStyle(style);
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		OutputStream out = null;
		try {
			wb.write(os);
			byte[] xls = os.toByteArray();
			out = new FileOutputStream(file);
			out.write(xls);
		} catch (IOException e) {
			logger.info(e.toString());
		} finally {
			try {
				if(wb!=null){
					wb.close();					
				}
				if(out!=null){
					out.close();
				}
				if(os!=null){
					os.close();					
				}
				logger.info("新建文件 "+fileName);
			} catch (IOException e) {
				logger.info(e.toString());
			}

		}
        
        
       
           
		
		
		
		
	}

}
