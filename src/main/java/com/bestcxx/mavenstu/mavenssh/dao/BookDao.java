package com.bestcxx.mavenstu.mavenssh.dao;

import java.util.List;
import java.util.Map;

import com.bestcxx.mavenstu.mavenssh.model.Book;

public interface BookDao{

	Book get(String id);
	
	List<Book> getListByHql(String hql,Map<String,String> map);
}
