package com.bestcxx.mavenstu.mavenssh.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisServer {
	
	/*
	 * Redis 默认是单机环境使用的。 数据量较大时需要shard（多机环境），
	 * 这个时候要用ShardedJedis。
	 *  ShardedJedis是基于一致性哈希算法实现的分布式Redis集群客户端
	 */
	/*
	 * https://my.oschina.net/XYleung/blog/101027
	 * 在不同的线程中使用相同的Jedis实例会发生奇怪的错误。
	 * 但是创建太多的实现也不好因为这意味着会建立很多sokcet连接，也会导致奇怪的错误发生。
	 * 单一Jedis实例不是线程安全的。
	 * 为了避免这些问题，可以使用JedisPool, JedisPool是一个线程安全的网络连接池。
	 * 可以用JedisPool创建一些可靠Jedis实例，可以从池中拿到Jedis的实例。
	 * 这种方式可以解决那些问题并且会实现高效的性能. 
	 */
	private JedisPool pool;
	private Jedis jedis;

	/**
	 * 
	 * @return
	 */
	public JedisPool getPool() {
		if (pool == null) {
			JedisPoolConfig config = new JedisPoolConfig();
			// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
			config.setMaxTotal(500);
			// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
			config.setMaxIdle(5);
			//多长空闲时间之后回收空闲连接
			config.setMinEvictableIdleTimeMillis(60000);
			//设置初始化连接数
			config.setMinIdle(10);
			// 最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
			config.setMaxWaitMillis(1000 * 100);
			// 在borrow一个jedis实例时,是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
			config.setTestOnBorrow(true);
			//在return给pool时，是否提前进行validate操作；
			config.setTestOnReturn(false);
			//启动空闲连接的测试
			config.setTestWhileIdle(false);
			//pool = new JedisPool(config, "192.168.1.100", 6379);
			pool = new JedisPool(config, "127.0.0.1", 6379);
		}
		return pool;
	}

	/**
	 * 构造方法，创建Redis链接
	 */
	public RedisServer() {
		pool = getPool();
		if (jedis == null) {
			jedis = pool.getResource();
			System.out.println("新创建了Redis链接");
		}
	}
	
	/**
	 * 返还实例，避免多线程操作混乱
	 */
	public void redisServerJedisOver() {
		//这里很重要，一旦拿到的jedis实例使用完毕，必须要返还给池中
		jedis.close();
		
	}
	
	/**
	 * 程序关闭时，关闭资源
	 */
	public void redisServerPoolOver(){
		//关闭资源
		pool.destroy();
	}
	
	

	/**
	 * Redis新添加数据-覆盖重写数据
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean redisSet(String key,String value){
		jedis.set(key, value);
		return true;
	}
	
	/**
	 * Redis根据key获取value
	 * @param key
	 * @return
	 */
	public Object redisGet(String key){
		return jedis.get(key);
	}
	
	/**
	 * Redis一新增/重定义两个值
	 * @param key0
	 * @param value0
	 * @param key1
	 * @param value1
	 * @return
	 */
	public boolean redisMset(String key0,String value0,String key1,String value1){
		jedis.mset(key0, value0,key1,value1);
		return true;
	}
	
	/**
	 * Redis-根据连个value获取两个值
	 * @param key0
	 * @param key1
	 * @return
	 */
	public List<String> redisMget(String key0,String key1){
		return jedis.mget(key0,key1);
	}
	
	/**
	 * Redis在原来的基础修改数据
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean redisAppend(String key,String value){
		return "OK".equals(jedis.append(key, value));
	}
	
	/**
	 * Redis删除数据
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean redisDel(String key,String value){
		return "OK".equals(jedis.del(key,value));
	}
	
	/**
	 * Redis 操作List
	 */
	/**
	 * Redis 覆盖指定list的指定序数位置的元素值
	 * @param key list 名称
	 * @param index  序数位
	 * @param value  保存的元素值
	 * @return
	 */
	public boolean redisLset(String key,Integer index,String value){
		return "OK".equals(jedis.lset(key, index, value));
	}
	
	/**
	 * Reids 在list末尾增加一个或多个值
	 * @param key list名横
	 * @param strings  值串，比如：1,2,3多个参数或者数组
	 * @return
	 */
	public Long redisRpush(String key,String ...strings){
		return jedis.rpush(key, strings);
	}
	
	/**
	 * Redis删除list第一个元素，并返回删除的元素
	 * @param key list的名字
	 * @return
	 */
	public String redisLpop(String key){
		return jedis.lpop(key);
	}
	
	/**
	 * Redis 获取 list 的 第 index个元素
	 * @param key
	 * @param i
	 * @return
	 */
	public String redisLindex(String key,Long i){
		return jedis.lindex(key, i);
	}
	
	/**
	 * Redis 操作 hashmap  
	 */
	/**
	 * Redis hashMap 存储
	 * @param key     hashmap 的 名字
	 * @param field   map<key,value>的key值
	 * @param value   map<key,value>的value 值
	 * @return
	 */
	public Long redisHset(String key,String field,String value){
		return jedis.hset(key, field, value);
	}
	
	/**
	 * Redis hashMap 取值
	 * @param key     hashmap 的 名字
	 * @param field   map<key,value>的key值
	 * @return
	 */
	public String redisHget(String key,String field){
		return jedis.hget(key, field);
	};
	
}
