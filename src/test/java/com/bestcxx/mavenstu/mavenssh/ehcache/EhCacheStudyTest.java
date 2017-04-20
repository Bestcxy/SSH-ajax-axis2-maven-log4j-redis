package com.bestcxx.mavenstu.mavenssh.ehcache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ehcache.Cache;
import org.ehcache.spi.loaderwriter.CacheLoadingException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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
	
	private static EhCacheStudy<Long, String> ehCacheStudy;
	
	private static Cache singletonCache;
	
	@BeforeClass
	public static void Before(){
		ehCacheStudy=new EhCacheStudyImpl();		
		singletonCache=(Cache<Long, String>) ehCacheStudy.getSingletonCache("newCache");
	}
	
	//在单例模式中 保存一个变量 1L-This is a test for Ehcache
	@Test
	public void testGetNewCache(){
		singletonCache.put(1L, "This is a test for Ehcache");
		logger.info("\n"+singletonCache.get(1L));
	}
	
	//单例模式 获取变量 1L-This is a test for Ehcache
	@Test
	public void testGetNewCache2(){
		logger.info("\n 从缓存中获取："+singletonCache.get(1L));
	}
	
	@Test
	public void testCloseCacheManager(){
		ehCacheStudy.closeCacheManager();
		logger.info("\n 关闭 cacheManager");
	}
	
	
	@AfterClass
	public static void After(){
		//测试结果已经无法获取，说明 Ehcache 已经被关闭了
		try {
			TestCase.assertEquals("true",singletonCache.get(1L).equals("This is a test for Ehcache"));
			logger.info("\n "+singletonCache.get(1L));
		} catch (IllegalStateException e) {
			logger.info("\n 测试结果已经无法获取，说明 Ehcache 已经被关闭了");
			TestCase.assertEquals("没有出现预计的异常则junit无法通过",e.getMessage(),"State is UNINITIALIZED");
		}
	}
	
	
	
	
	
}
