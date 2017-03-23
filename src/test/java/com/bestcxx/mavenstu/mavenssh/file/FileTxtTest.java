package com.bestcxx.mavenstu.mavenssh.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestcxx.mavenstu.mavenssh.service.FileTxtModelService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理  
@Rollback(false)
public class FileTxtTest {
	@Autowired
	private FileTxtModelService fileTxtModelService;
	
	@Test
	public void testReadFileTxt(){
		FileTxt f=new FileTxt(fileTxtModelService);
		f.ReadFileTxt();
	}

}
