package com.bestcxx.mavenstu.mavenssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestcxx.mavenstu.mavenssh.dao.PersonDao;
import com.bestcxx.mavenstu.mavenssh.model.Person;
import com.bestcxx.mavenstu.mavenssh.service.PersonService;
@Service
//@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	@Override
	public boolean addPerson(Person person) {
		if(personDao.addPerson(person)){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkPerson(Person person) {
		if(personDao.checkPerson(person)){
			return true;
		}
		return false;
	}

	@Override
	public Person getPersonByUserName(String userName) {
		// TODO Auto-generated method stub
		return personDao.getPersonByUserName(userName);
	}

	
	
}
