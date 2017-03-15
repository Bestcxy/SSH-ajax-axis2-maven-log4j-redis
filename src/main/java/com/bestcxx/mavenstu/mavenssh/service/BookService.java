package com.bestcxx.mavenstu.mavenssh.service;

import java.util.List;

import com.bestcxx.mavenstu.mavenssh.model.Book;

public interface BookService {
	Book get(String id);
	List<Book> getAllList();
}
