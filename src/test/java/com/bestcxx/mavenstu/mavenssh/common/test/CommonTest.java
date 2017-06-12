package com.bestcxx.mavenstu.mavenssh.common.test;

import java.util.Map;

import org.junit.Test;

import java.util.HashMap;

public class CommonTest {
	
	
	/**
	 * 类型转化测试
	 * @instruction
	 * @Datetime 2017年6月12日 下午2:55:40
	 * 对于数据库中字符类型可能为 long 或者 Integer 的，为了防止类型转化不一致的风险，先一致转化为 String
	 * 如需比较大小，将 String 转化为Integer即可 
	 */
	@Test
	public void testHashMap(){
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("numlong", Long.valueOf(1));
		//map.put("numlong", null);
		map.put("numInteger",new Integer("1"));
		//map.put("numInteger",null);
		if((Long)map.get("numlong")!=null){
			System.out.println(((Long)map.get("numlong")>0));
			
			System.out.println(new Integer((String)map.get("numlong").toString())>0);
		}
		if((Integer)map.get("numInteger")!=null){
			System.out.println(((Integer)map.get("numInteger")>0));
			
			System.out.println(new Integer((String)map.get("numInteger").toString())>0);
		}
		
	}

}
