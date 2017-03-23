package com.bestcxx.mavenstu.mavenssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestcxx.mavenstu.mavenssh.dao.FileTxtModelDao;
import com.bestcxx.mavenstu.mavenssh.model.FileTxtModel;
import com.bestcxx.mavenstu.mavenssh.service.FileTxtModelService;

@Service
public class FileTxtModelServiceImpl implements FileTxtModelService {
	@Autowired
	FileTxtModelDao fileTxtModelDao;
	
	@Override
	public boolean add(FileTxtModel fileTxtModel) {
		return fileTxtModelDao.add(fileTxtModel);
	}

}
