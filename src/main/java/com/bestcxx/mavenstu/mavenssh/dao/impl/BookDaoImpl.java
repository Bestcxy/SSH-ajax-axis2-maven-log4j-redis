package com.bestcxx.mavenstu.mavenssh.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bestcxx.mavenstu.mavenssh.dao.BookDao;
import com.bestcxx.mavenstu.mavenssh.model.Book;

@Repository
public class BookDaoImpl extends BaseDaoImpl<Book,String> implements BookDao {

	@Override
	public Book get(String pk) {
		// TODO Auto-generated method stub
		return super.get(pk);
	}

	@Override
	protected Class<Book> getEntityClass() {
		// TODO Auto-generated method stub
		return Book.class;
	}

	@Override
	public List<Book> getListByHql(String hql,Map<String,String> map) {
		// TODO Auto-generated method stub
		return super.getAnyListByHql(hql,map);
	}

	

	

}
