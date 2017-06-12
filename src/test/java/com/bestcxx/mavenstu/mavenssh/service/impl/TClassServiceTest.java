package com.bestcxx.mavenstu.mavenssh.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestcxx.mavenstu.mavenssh.model.TClass;
import com.bestcxx.mavenstu.mavenssh.service.TClassService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理  
@Rollback(false)
public class TClassServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	TClassService tclassService;
	
	@Test 
	public void testAdd(){
		TClass tclass=new TClass();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		Date date=new Date();
		tclass.setClassName(sdf.format(date));
		tclass.setInsertDateTime(date);
		tclassService.add(tclass);
	}
	
	@Test
	public void testGet(){
		TClass tclass=tclassService.get("20170205220443");
		if(tclass==null){
			System.out.println("没有查询结果");
		}else{
			System.out.println(tclass.getClassName());
		}
		
	}
	
	@Test
	public void testGetAllList(){
		List<TClass> tclasss=tclassService.getAllList();
		if(tclasss.size()==0){
			System.out.println("目前表中数据为0");
		}else{
			for(TClass tclass:tclasss){
				System.out.println(tclass.getClassName());
			}
		}
		
	}
	
}
