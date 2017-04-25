package com.bestcxx.mavenstu.mavenssh.singolen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @theme 一个普通的类 
 * @author wujie
 * @Datetime 2017年4月25日 上午10:43:29
 * Desc:这只是一个普通的类
 */
public class AnotherCommonClass {
	private static Logger logger = LogManager.getLogger(AnotherCommonClass.class); 
	
	
	public AnotherCommonClass(){
		logger.info("\nAnotherCommonClass.java 被实例化");
	}
	
	public void method2(){
		logger.info("\nAnotherCommonClass.java 的方法 method2");
	}
}
