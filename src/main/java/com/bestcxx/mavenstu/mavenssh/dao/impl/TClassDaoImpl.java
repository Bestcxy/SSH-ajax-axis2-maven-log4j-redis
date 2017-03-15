package com.bestcxx.mavenstu.mavenssh.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bestcxx.mavenstu.mavenssh.dao.TClassDao;
import com.bestcxx.mavenstu.mavenssh.model.TClass;

@Repository
public class TClassDaoImpl extends BaseDaoByGenericImpl<TClass,String> implements TClassDao {

	@Override
	public TClass get(String pk) {
		// TODO Auto-generated method stub
		return super.get(pk);
	}
	
	@Override
	public List<TClass> getListByHql(String hql,Map<String,String> map) {
		// TODO Auto-generated method stub
		return super.getAnyListByHql(hql,map);
	}

	@Override
	public boolean add(TClass tclass) {
		// TODO Auto-generated method stub
		return super.add(tclass);
	}

	
	
	

	

}
