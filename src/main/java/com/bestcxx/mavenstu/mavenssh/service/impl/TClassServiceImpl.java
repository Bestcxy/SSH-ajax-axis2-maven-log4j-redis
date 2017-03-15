package com.bestcxx.mavenstu.mavenssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestcxx.mavenstu.mavenssh.dao.TClassDao;
import com.bestcxx.mavenstu.mavenssh.model.TClass;
import com.bestcxx.mavenstu.mavenssh.service.TClassService;
@Service
public class TClassServiceImpl implements TClassService {

	@Autowired
	TClassDao tclassDao;
	@Override
	public TClass get(String id) {
		// TODO Auto-generated method stub
		return (TClass) tclassDao.get(id);
	}
	@Override
	public List<TClass> getAllList() {
		// TODO Auto-generated method stub
		String hql="from TCLASS";
		return tclassDao.getListByHql(hql,null);
	}
	@Override
	public boolean add(TClass tclass) {
		// TODO Auto-generated method stub
		return tclassDao.add(tclass);
	}
	
	
}
