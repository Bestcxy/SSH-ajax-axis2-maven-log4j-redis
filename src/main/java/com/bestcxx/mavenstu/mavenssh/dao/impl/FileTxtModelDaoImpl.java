package com.bestcxx.mavenstu.mavenssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.bestcxx.mavenstu.mavenssh.dao.FileTxtModelDao;
import com.bestcxx.mavenstu.mavenssh.model.FileTxtModel;

@Repository
public class FileTxtModelDaoImpl extends BaseDaoByGenericImpl<FileTxtModel, Integer> implements FileTxtModelDao{

	@Override
	public boolean add(FileTxtModel t) {
		// TODO Auto-generated method stub
		return super.add(t);
	}
	
}
