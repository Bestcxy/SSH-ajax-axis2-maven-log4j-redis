package com.bestcxx.mavenstu.mavenssh.office.excel.xssf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * 实验创建新的 Excel 的 xlsx
 * 
 * @author WuJieJecket
 *
 */
public class NewWorkbookTest {

	/**
	 * 新建 workbook,可以认为新建了一个excel文件，内部什么也没有
	 * http://poi.apache.org/spreadsheet/quick-guide.html#NewWorkbook
	 * @throws IOException
	 */
	@Test
	public void testNewWorkbook() throws IOException {
		Workbook wb = new XSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream("D:/workbook.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}
	
	/**
	 * 为新建的workbook添加一个sheet，即excel工作簿的一个分页,可以自定义名字
	 * http://poi.apache.org/spreadsheet/quick-guide.html#New+Sheet
	 */
	@Test
	public void testCreateSheet() throws IOException{
		Workbook wb = new XSSFWorkbook();
		wb.createSheet("自定义sheet1");
		wb.createSheet();
		FileOutputStream fileOut = new FileOutputStream("D:/workbook.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}
	
	/**
	 * 添加单元格，先添加行 row,再添加列，cell
	 * http://poi.apache.org/spreadsheet/quick-guide.html#Creating+Cells
	 * @throws IOException
	 *     CreationHelper createHelper = wb.getCreationHelper();
	 */
	@Test
	public void testCreateCell() throws IOException{
		Workbook wb=new XSSFWorkbook();
	    CreationHelper createHelper = wb.getCreationHelper();

		Sheet sheet1=wb.createSheet("自定义sheet1");
		// Create a row and put some cells in it. Rows are 0 based.
		//创建一个行，首行为第0行，并且为之添加一些表格
		Row row0=sheet1.createRow((short)0);
		
		// Create a cell and put a value in it.
		//创建一个表格，然后添加到某一行中,表格是按照列添加的，从0开始计数
		//也可以直接在row中添加
		Cell cell00=row0.createCell(0);
		cell00.setCellValue("第0个");
		
		row0.createCell(1).setCellValue("第1个");
		row0.createCell(2).setCellValue(2.0);
		row0.createCell(3).setCellValue(true);
		row0.createCell(4).setCellValue(
				createHelper.createRichTextString("来自 createHelper"));
		
		FileOutputStream fileOut = new FileOutputStream("D:/workbook.xlsx");
		wb.write(fileOut);
		fileOut.close();
		
	}
	
	/**
	 * 时间格式的表格
	 * http://poi.apache.org/spreadsheet/quick-guide.html#Creating+Date+Cells
	 * @throws IOException
	 */
	@Test
	public void testCreateDateCell() throws IOException{
		Workbook wb=new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet=wb.createSheet("自动以sheet");
		Row row=sheet.createRow(0);
		// Create a cell and put a date value in it.  The first cell is not styled
	    // as a date.
		//不加设定的时间格式
		row.createCell(0).setCellValue(new Date());
		
		// we style the second cell as a date (and time).  It is important to
	    // create a new cell style from the workbook otherwise you can end up
	    // modifying the built in style and effecting not only this cell but other cells.
	    //定义一个样式
		CellStyle cellStyle = wb.createCellStyle();
	    cellStyle.setDataFormat(
	        createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
	    
	    //时间 Date
	    Cell cell1=row.createCell(1);
	    cell1.setCellStyle(cellStyle);
	    cell1.setCellValue(new Date());
	    
	    //you can also set date as java.util.Calendar
	    //时间 Calendar
	    Cell cell2=row.createCell(2);
	    cell2.setCellValue(Calendar.getInstance());
	    cell2.setCellStyle(cellStyle);
	    
		FileOutputStream fileOut = new FileOutputStream("D:/workbook.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}
	
	/**
	 * http://poi.apache.org/spreadsheet/quick-guide.html#Merging+cells
	 * 合并单元格
	 */
	@Test
	public void testSheetAddMergedRegion() throws IOException{
		Workbook wb=new XSSFWorkbook();
		Sheet sheet=wb.createSheet("自定义sheet");
		
		Row row=sheet.createRow((short)0);
	    Cell cell=row.createCell((short)0);
	    cell.setCellValue("Just do it");
	    
	    //合并单元格
	    CellRangeAddress CellRangeAddress=new CellRangeAddress(0, 2, 0, 2);
	    sheet.addMergedRegion(CellRangeAddress);
	    
	    FileOutputStream fileOut = new FileOutputStream("D:/workbook.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}
	
	

}
