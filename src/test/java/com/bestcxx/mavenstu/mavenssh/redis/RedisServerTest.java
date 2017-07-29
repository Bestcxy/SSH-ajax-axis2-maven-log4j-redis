package com.bestcxx.mavenstu.mavenssh.redis;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

//@Ignore
public class RedisServerTest {
	private RedisServer redisServer;
	@Before
	public void begin(){
		redisServer=new RedisServer();
	}
	
	@Test
	public void testRedisSet(){
		System.out.println(redisServer.redisGet("name"));
		redisServer.redisSet("name", "jecket");
		System.out.println(redisServer.redisGet("name"));
		
		redisServer.redisLset("list1", 2, "10");
		
	
		redisServer.redisServerJedisOver();
		redisServer.redisServerPoolOver();
	}
	@Test
	public void testRedisRpush(){
		/**保存多个参数*/
		Long size=redisServer.redisRpush("list1", "namea","nameb","namec");
		
		System.out.println("List 现在的 size="+size);
		
		/**保存数组*/
		String[] s={"1","2","3"};
		Long size2=redisServer.redisRpush("list1", s);
		System.out.println("List 现在的 size2="+size2);
	}
	
	@Test
	public void testRedisLpop(){
		String value=redisServer.redisLpop("list1");
		System.out.println("第一个元素被删除，这个元素为="+value);
	}
	
	@Test
	public void testRedisLindex(){
		String value=redisServer.redisLindex("list1", 1L);
		System.out.println("队列第一个值为="+value);
	}
}

