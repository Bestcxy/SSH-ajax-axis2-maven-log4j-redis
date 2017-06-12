package com.bestcxx.mavenstu.mavenssh.redis;

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
		System.out.println(redisServer.RedisGet("name"));
		redisServer.RedisSet("name", "jecket");
		System.out.println(redisServer.RedisGet("name"));
		
		redisServer.RedisServerJedisOver();
		redisServer.RedisServerPoolOver();
	}
}
