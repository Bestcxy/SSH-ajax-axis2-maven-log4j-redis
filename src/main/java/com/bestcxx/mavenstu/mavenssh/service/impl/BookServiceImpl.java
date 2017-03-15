package com.bestcxx.mavenstu.mavenssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestcxx.mavenstu.mavenssh.dao.BookDao;
import com.bestcxx.mavenstu.mavenssh.model.Book;
import com.bestcxx.mavenstu.mavenssh.service.BookService;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	@Override
	public Book get(String id) {
		// TODO Auto-generated method stub
		return (Book) bookDao.get(id);
	}
	@Override
	public List<Book> getAllList() {
		// TODO Auto-generated method stub
		String hql="from BOOK";
		return bookDao.getListByHql(hql,null);
	}
	
	
}
