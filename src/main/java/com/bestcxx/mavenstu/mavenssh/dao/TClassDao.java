package com.bestcxx.mavenstu.mavenssh.dao;

import java.util.List;
import java.util.Map;

import com.bestcxx.mavenstu.mavenssh.model.TClass;

public interface TClassDao{

	TClass get(String id);
	
	List<TClass> getListByHql(String hql,Map<String,String> map);
	
	boolean add(TClass tclass);
}
