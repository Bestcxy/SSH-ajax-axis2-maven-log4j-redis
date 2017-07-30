package com.bestcxx.mavenstu.mavenssh.redis;

import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
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
	
	@Test
	public void testRedisHset(){
		String key="hashmap";
		String field="map3";
		String value="map3";
		Long result=redisServer.redisHset(key, field, value);
		System.out.println("result="+result);
	}
	
	@Test
	public void testRedisHget(){
		String key="hashmap";
		String field="map3";
		String result=redisServer.redisHget(key, field);
		System.out.println("result="+result);

	}
	
	@Test
	public void testSAdd(){
		String key="mao";
		String[] members={"map1","map2","map3"};
		redisServer.sAdd(key, members);
	}
	
	@Test
	public void testSMembers(){
		String key="mao";
		Set<String> set=redisServer.sMembers(key);
		
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	@Test
	public void testZAdd(){
		String key="sortmap";
		double score=0;
		String member="testSortMap";
		redisServer.zAdd(key, score, member);
	}
	
	@Test
	public void testZRange(){
		String key="sortmap";
		double min=0;
		double max=5;
		Set<String> set=redisServer.zRange(key, min, max);
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
}


