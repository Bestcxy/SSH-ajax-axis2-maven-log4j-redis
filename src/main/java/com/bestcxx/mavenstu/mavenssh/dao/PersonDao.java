package com.bestcxx.mavenstu.mavenssh.dao;

import com.bestcxx.mavenstu.mavenssh.model.Person;

public interface PersonDao {
	/**
	 * 保存新用户到数据库
	 * @param person
	 * @return
	 */
	public boolean addPerson(Person person);
	
	/**
	 * 查询用户是否存在，若已存在，则返回true
	 * @param person
	 * @return
	 */
	public boolean checkPerson(Person person);
	
	/**
	 * 根据用户名查询用户
	 * @param userName
	 * @return
	 */
	public Person getPersonByUserName(String userName);
}
