package com.bestcxx.mavenstu.mavenssh.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理  
@Rollback(false)
public class TestForAll {
	/**
	 * 测试root日志打印到控制台
	 */
	@Test
	public void testLog4j2(){
		Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);  
	    logger.trace("trace level");  
	    logger.debug("debug level");  
	    logger.info("info level");  
	    logger.warn("warn level");  
	    logger.error("error level");  
	    logger.fatal("fatal level");  
	}
	/**
	 * 测试自定义日志打印到控制台
	 */
	@Test
	public void testLog4j2SC(){
		
		Logger logger = LogManager.getLogger("mylog");  
	    logger.trace("trace level");  
	    logger.debug("debug level");  
	    logger.info("info level");  
	    logger.warn("warn level");  
	    logger.error("error level");  
	    logger.fatal("fatal level");
	}
	
	/**
	 * 自动以日志输出到文件
	 */
	@Test
	public void testLog4j2SF(){
		Logger logger = LogManager.getLogger("mylogtofile");  
	    logger.trace("trace level");  
	    logger.debug("debug level");  
	    logger.info("info level");  
	    logger.warn("warn level");  
	    logger.error("error level");  
	    logger.fatal("fatal level");
	}
	
	/**
	 * 自动以日志输出到文件
	 * 滚动输出
	 */
	@Test
	public void testLog4j2SFR(){
		//Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);//根日志
		//Logger logger = LogManager.getLogger("mylogtofileroll");//自定义日志
		Logger logger = LogManager.getLogger(TestForAll.class);//以类名作为日志的名字
		
	    logger.trace("trace level");  
	    logger.debug("debug level");  
	    logger.info("info level");  
	    logger.warn("warn level");  
	    logger.error("error level");  
	    logger.fatal("fatal level");
	}
	
	/**
	 * 自动以日志输出到控制台
	 * 过滤器
	 * 日志级别是
	 * trace->debug->info->warn->error->fatal
	 * 本例中是
	 * 1、fatal 级别不输出
	 * 2、warn级别以及之后输出
	 * 综合是 warn之后以及fatal（不含fatal）级别之前输出
	 * 
	 */
	@Test
	public void testLog4j2ErrorNoFatal(){
		Logger logger = LogManager.getLogger("toConsoleFilter");  
	    logger.trace("trace level");  
	    logger.debug("debug level");  
	    logger.info("info level");  
	    logger.warn("warn level");  
	    logger.error("error level");  
	    logger.fatal("fatal level");
	}
	
	/**
	 * 异步输出日志
	 * 
	 */
	@Test
	public void testLog4j2asyncConsole(){
		Logger logger = LogManager.getLogger("asyncConsole");  
	    logger.trace("trace level");  
	    logger.debug("debug level");  
	    logger.info("info level");  
	    logger.warn("warn level");  
	    logger.error("error level");  
	    logger.fatal("fatal level");
	}
	
}
