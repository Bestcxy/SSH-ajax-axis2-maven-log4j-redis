package com.bestcxx.mavenstu.mavenssh.ehcache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 
 * @theme 对 Ehcache 的测试类
 * @author wujie
 * @Datetime 2017年4月20日 下午3:12:38
 */
public class EhCacheStudyTest {
	private static Logger logger = LogManager.getLogger(EhCacheStudyTest.class); 
	
	private static final String keyStr1="keyStr1";//Ehcache 存储的key值
	
	@BeforeClass
	public static void Before(){
		logger.info("\n 要开始试验了哦");
	}
	
	//在单例模式中 保存一个变量 1L-This is a test for Ehcache
	@Test
	public void testGetNewCache(){
		EhCacheStudy.getSingletonCache().put(keyStr1, "This is a test for Ehcache");
		logger.info("\n"+EhCacheStudy.getSingletonCache().get(keyStr1));
	}
	
	//单例模式 获取变量 1L-This is a test for Ehcache
	@Test
	public void testGetNewCache2(){
		logger.info("\n 从缓存中获取："+EhCacheStudy.getSingletonCache().get(keyStr1));
	}
	
	//将指定cache从 cacheManger 移除
	 @Ignore @Test
	public void testRemoveCache(){
		 EhCacheStudy.removeCache();
		logger.info("\n 默认 cache 已经从cacheManager 中移除");
	}
	
	//关闭cacheManager
	 @Ignore @Test
	public void testCloseCacheManager(){
		 EhCacheStudy.closeCacheManager();
		logger.info("\n 关闭 cacheManager");
	}
	
	
	@AfterClass
	public static void After(){
		//测试结果已经无法获取，说明 Ehcache 已经被关闭了
		try {
			TestCase.assertEquals(true,EhCacheStudy.getSingletonCache().get(keyStr1).equals("This is a test for Ehcache"));
			logger.info("\n AfterClass:"+EhCacheStudy.getSingletonCache().get(keyStr1));
		} catch (IllegalStateException e) {
			logger.info("\n 测试结果已经无法获取，说明 Ehcache 已经被关闭了");
			TestCase.assertEquals("没有出现预计的异常则junit无法通过",e.getMessage(),"State is UNINITIALIZED");
		}
	}
	
}
