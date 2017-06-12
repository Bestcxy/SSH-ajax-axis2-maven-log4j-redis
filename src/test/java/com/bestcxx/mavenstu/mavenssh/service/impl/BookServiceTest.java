package com.bestcxx.mavenstu.mavenssh.service.impl;

import java.util.List;

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
public class BookServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	BookService bookService;
	
	@Test
	public void testGet(){
		Book book=bookService.get("20170122011448");
		if(book==null){
			System.out.println("没有查询结果");
		}else{
			System.out.println(book.getBookName());
		}
		
	}
	
	@Test
	public void testGetAllList(){
		List<Book> books=bookService.getAllList();
		if(books.size()==0){
			System.out.println("目前表中数据为0");
		}else{
			for(Book book:books){
				System.out.println(book.getBookName());
			}
		}
		
	}
	
}
