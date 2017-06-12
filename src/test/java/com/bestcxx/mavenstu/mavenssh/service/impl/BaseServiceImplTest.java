package com.bestcxx.mavenstu.mavenssh.service.impl;

import java.text.SimpleDateFormat;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestcxx.mavenstu.mavenssh.model.Book;
import com.bestcxx.mavenstu.mavenssh.service.BookService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理  
@Rollback(false)
public class BaseServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	private BookService bookService;
	
	//增
	//@Test
	/*public void testBaseDaoImplAdd(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		Book book=new Book();
		book.setBookName(sdf.format(new Date()));
		book.add(book);//20170122011448
		
	}*/
	//删
	//@Test
	/*public void testBaseDaoImplDel(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		Book book=new Book();
		book.setBookName(sdf.format(new Date()));
		book.setBookName("20170122013624");
		baseService.del(book);
	}*/
	//按照id查
	@Test
	@Ignore
	public void testBaseDaoImplUpdate(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		Book book=(Book) bookService.get("20170122011448");
		System.out.println( book.getBookName());
		TestCase.assertEquals("20170122011448", book.getBookName());
	}
}  
