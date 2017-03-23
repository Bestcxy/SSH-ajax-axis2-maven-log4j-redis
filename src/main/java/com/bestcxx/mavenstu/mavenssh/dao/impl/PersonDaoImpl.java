package com.bestcxx.mavenstu.mavenssh.dao.impl;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bestcxx.mavenstu.mavenssh.dao.PersonDao;
import com.bestcxx.mavenstu.mavenssh.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	private SessionFactory sessionFactory;
	
	@Autowired
	public PersonDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory=sessionFactory;
	}
	
	//获取当前session
	private Session currentSession(){	
		return sessionFactory.getCurrentSession();
	}
	@Override
	public boolean addPerson(Person person) {
		currentSession().save(person);
		return true;
	}

	@Override
	public boolean checkPerson(Person person) {
		String hql="from PERSON where userName=:userName";
		Query query=currentSession().createQuery(hql).setString("userName", person.getUserName());
		if(query.list().size()>0){
			return true;
		}
		return false;
	}

	@Override
	public Person getPersonByUserName(String userName) {
		// TODO Auto-generated method stub
		return (Person) currentSession().get(Person.class, userName);
	}

}
