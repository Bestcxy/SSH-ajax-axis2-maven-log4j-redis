package com.bestcxx.mavenstu.mavenssh.listtest;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.User;
import org.junit.Test;

import com.bestcxx.mavenstu.mavenssh.model.Book;

public class ListTest {
	
	@Test//不可行
	public void testListRemove(){
		List<Book> list=new ArrayList<Book>();
		Book b=new Book();
		b.setBookName("1");
		list.add(b);
		
		Book b2=new Book();
		b2.setBookName("2");
		list.add(b2);
		
		Book b3=new Book();
		b3.setBookName("3");
		list.add(b3);
		
		
		for(Book c:list){
			if("1".equals(c.getBookName())){
				list.remove(c);
			}
		}
		for(Book c:list){
			System.out.println(c.getBookName());
		}
	
	
	}

}
