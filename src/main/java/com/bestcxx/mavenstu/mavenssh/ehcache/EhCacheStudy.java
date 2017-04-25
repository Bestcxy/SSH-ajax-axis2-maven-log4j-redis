package com.bestcxx.mavenstu.mavenssh.ehcache;

import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import com.bestcxx.mavenstu.mavenssh.util.EnumUtil;

/**
 * @theme Ehcache 3.2
 *        http://www.ehcache.org/documentation/3.2/getting-started.html
 * @author wujie
 * @param <K>
 * @Datetime 2017年4月19日
 * 配置获取 CacheManager 的公共方法，然后是提供获取 Cache 的方法
 * 用法示例: preConfigured.put("keyStr", "This is preConfigured's value.");
 * String value0 = myCache.get(1L);
 * 
 */
public class EhCacheStudy {
	
	private static Logger logger = LogManager.getLogger(EhCacheStudy.class);
	private static CacheManager cacheManager;// 自定义cache
	private final static String alias=EnumUtil.EHCACHE_DEFAULT_NEWCACHE.toString();

	// 利用反射机制获取泛型类子类泛型参数的具体类型-这个必须写在构造方法中-注意，获取单例模式时，必须使用传参的构造方法
	private EhCacheStudy() {	
		//在构造方法中实现对cacehManager 的单例模式
		cacheManager=CacheManagerBuilder.newCacheManagerBuilder()
				.withCache(alias, CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class,
						String.class, ResourcePoolsBuilder.heap(100)).build())
				.build(true);// 这里设置为 true 和 对新创建的对象 init() 效果是一样的
								// cacheManager.init();
		logger.info("\n cacheManager实例化");
	}
	
	/**
	 * @theme 实现单例模式 
	 * @author wujie
	 * @Datetime 2017年4月25日
	 */
	private static class SingletonHolder{
        private final static EhCacheStudy instance=new EhCacheStudy();
    }
	
	/**
	 * 
	 * @instruction 获取单例的方法是：EhCacheStudy的子类的 getInstance()
	 * @Datetime 2017年4月20日 上午11:36:52
	 * @param alias
	 *            CacheManager 的别名
	 * @param keyClasType
	 *            Cache的key 类型，比如Long
	 * @param valueClassType
	 *            Cached的value 类型,比如 String
	 * @return
	 */
	private static EhCacheStudy getSingletonCacheManager(){
        return SingletonHolder.instance;
    }
	

	/**
	 * 
	 * @instruction 获取指定名字的cache-单例模式-获取系统默认的Cache
	 * @Datetime 2017年4月20日 下午2:50:02
	 * @param alias
	 * @param keyClasType
	 * @param valueClassType
	 * @return
	 * @return
	 */
	public static Cache<String,String> getSingletonCache() {
		return  getSingletonCacheManager().cacheManager.getCache(alias, String.class,
				String.class);// 传递 Cache 别名，key 类型，value 类型
	}
	
	/**
	 * 
	 * @instruction 将制定的cache从 cacheManager 移除
	 * @Datetime 2017年4月21日 上午9:26:10
	 * @param alias
	 */
	public static void removeCache(){
		getSingletonCacheManager().cacheManager.removeCache(alias);
	}
	
	/**
	 * @instruction
	 * @Datetime 2017年4月20日 下午2:58:34
	 */
	public static void closeCacheManager() {
		if (getSingletonCacheManager().cacheManager != null) {
			getSingletonCacheManager().cacheManager.close();
		}
		
	}
}
