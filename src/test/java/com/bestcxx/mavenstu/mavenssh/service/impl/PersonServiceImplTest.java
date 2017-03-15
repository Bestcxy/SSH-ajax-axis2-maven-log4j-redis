package com.bestcxx.mavenstu.mavenssh.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestcxx.mavenstu.mavenssh.model.Person;
import com.bestcxx.mavenstu.mavenssh.service.PersonService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理  
@Rollback(false)
public class PersonServiceImplTest {
	@Autowired
	private PersonService personService;
	
	@Test
	public void testAddPerson(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		Person person=new Person();
		person.setUserName(sdf.format(new Date()));
		person.setPassWord("123456");
		
//		TestCase.assertEquals(true, personService.addPerson(person));
	}
	/*
	 * 正则表达式实验
	 */
	@Test
	public void testValidate(){
		String str="+860123456789";
		String regex="^(\\+86|0|1)\\d{10,11}$";//^(\+86|0|1)\d{10,11}$
//		String regex="^(\\+86|0|1)\\d{10,11}$";//^(\+86|0|1)\d{10,11}$
//		String regex="^(\\+86|0|1)";//^(\+86|0|1)\d{10,11}$
		Pattern pattern=Pattern.compile(regex);
		 Matcher m = pattern.matcher(str);
		TestCase.assertEquals(true, m.matches());
		
	}
	
	@Test
	public void testGetPersonByUserName(){
		Person p=personService.getPersonByUserName("123");
		System.out.println("password="+p.getPassWord());
		
	}

}
