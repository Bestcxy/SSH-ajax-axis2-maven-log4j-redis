package com.bestcxx.mavenstu.mavenssh.ehcache;

import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.junit.Test;

/**
 * @theme Ehcache 3.2
 *        http://www.ehcache.org/documentation/3.2/getting-started.html
 * @author wujie
 * @param <K>
 * @Datetime 2017年4月19日 上午11:08:22 
 * 配置获取 CacheManager 的公共方法，然后是提供获取 Cache 的方法
 * 用法示例: preConfigured.put(1L, "This is preConfigured's value.");
 * String value0 = myCache.get(1L);
 * 
 */
public class EhCacheStudy<T, K> {
	private CacheManager cacheManager;// 自定义cache

	protected Class<T> tClass;
	protected Class<K> kClass;

	// 利用反射机制获取泛型类子类泛型参数的具体类型-这个必须写在构造方法中
	public EhCacheStudy() {
		tClass = (Class<T>) getModelClass(tClass, 0);
		kClass = (Class<K>) getModelClass(kClass, 1);
	}

	// 泛型类作为父类，可以获取子类的所有实际参数的类型
	@SuppressWarnings("unchecked")
	public Class<?> getModelClass(Class modelClass, int index) {
		Type genType = this.getClass().getGenericSuperclass();// 得到泛型父类
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();// 一个泛型类可能有多个泛型形参，比如ClassName<T,K>
																				// 这里有两个泛型形参T和K，Class
																				// Name<T>
																				// 这里只有1个泛型形参T
		if (params.length - 1 < index) {
			modelClass = null;
		} else {
			modelClass = (Class) params[index];
		}

		return modelClass;

	}

	/**
	 * 当需要获取指定的Cache的时候
	 * 
	 * @param alias
	 * @param keyClasType
	 * @param valueClassType
	 */
	private CacheManager cacheManagerInstances(String alias) {
		cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
				.withCache(alias, CacheConfigurationBuilder.newCacheConfigurationBuilder(tClass,
						kClass, ResourcePoolsBuilder.heap(100)).build())
				.build(true);// 这里设置为 true 和 对新创建的对象 init() 效果是一样的
								// cacheManager.init();
		return cacheManager;
	}

	/**
	 * 
	 * @instruction
	 * @Datetime 2017年4月20日 上午11:36:52
	 * @param alias
	 *            CacheManager 的别名
	 * @param keyClasType
	 *            Cache的key 类型，比如Long
	 * @param valueClassType
	 *            Cached的value 类型,比如 String
	 * @return
	 */
	private CacheManager getSingletonCacheManager(String alias) {
		if (cacheManager == null) {
			cacheManager = cacheManagerInstances(alias);
		}
		return cacheManager;
	}

	/**
	 * 
	 * @instruction 用户输入Cache的名字，获取一个以这个名字命名的 cache 的新实例
	 * @Datetime 2017年4月20日 下午2:26:42
	 * @param alias
	 *            Cache 的别名
	 * @param keyClasType
	 *            Cache的key 类型，比如Long
	 * @param valueClassType
	 *            Cached的value 类型,比如 String
	 * @return
	 */
	public Cache<T, K> getNewCache(String alias) {
		return (Cache<T, K>) getSingletonCacheManager(alias).createCache(alias,
				CacheConfigurationBuilder.newCacheConfigurationBuilder(tClass,
						kClass, ResourcePoolsBuilder.heap(100)).build());
	}

	/**
	 * 
	 * @instruction 获取指定名字的cache-单例模式
	 * @Datetime 2017年4月20日 下午2:50:02
	 * @param alias
	 * @param keyClasType
	 * @param valueClassType
	 * @return
	 * @return
	 */
	public Cache<T, K> getSingletonCache(String alias) {
		return (Cache<T, K>) getSingletonCacheManager(alias).getCache(alias, tClass,
				kClass);// 传递 Cache 别名，key 类型，value 类型
	}

	/**
	 * @instruction
	 * @Datetime 2017年4月20日 下午2:58:34
	 */
	public void closeCacheManager() {
		if (cacheManager != null) {
			cacheManager.close();
		}
		
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	
}
