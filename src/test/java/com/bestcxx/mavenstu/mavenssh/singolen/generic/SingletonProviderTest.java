package com.bestcxx.mavenstu.mavenssh.singolen.generic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.bestcxx.mavenstu.mavenssh.model.Person;

public class SingletonProviderTest {
	private static Logger logger = LogManager.getLogger(SingletonProviderTest.class); 
	
	@Test
	public void testGetSingleton(){
		/***
		 * 以People 为例 获取其实例化
		 */
		Person str = SingletonProvider.getSingleton(Person.class);
		/***
		 * 设置测试数据
		 */
		str.setUserName("123456");
		str.setPassWord("7890");
		
		Person s= SingletonProvider.getSingleton(Person.class);
		
		logger.info(s.getUserName()+"--"+s.getPassWord());
	}

}
