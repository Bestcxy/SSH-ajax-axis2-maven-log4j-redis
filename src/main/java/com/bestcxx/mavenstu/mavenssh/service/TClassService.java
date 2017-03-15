package com.bestcxx.mavenstu.mavenssh.service;

import java.util.List;

import com.bestcxx.mavenstu.mavenssh.model.TClass;

public interface TClassService {
	TClass get(String id);
	List<TClass> getAllList();
	boolean add(TClass tclass); 
}
