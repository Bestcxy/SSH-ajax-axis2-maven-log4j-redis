package com.bestcxx.mavenstu.mavenssh.map;

import java.util.HashMap;

import org.junit.Test;

public class MapTest {
	
	/**
	 * @instruction 对于map为null的情况判断
	 * @Datetime 2017年4月18日 上午11:26:54
	 */
	@Test
	public void testMapIsNull(){
		inneUser in=new inneUser("flag");
		
		HashMap<String,Object> hash=new HashMap<String,Object>();
		hash.put("id", in.getId());
		hash.put("name",in.getName());
		hash.put("flag", in.getFlag());
		
		String flag=(String)hash.get("flag");
		String id=hash.get("id")==null?"Null":"NotNull";//int类型，默认赋值为0
		String name=(String)hash.get("name");
		
		System.out.println(flag);
		System.out.println(id);
		System.out.println(name);
		
	}

}

/**
 * @theme 一个实体类
 * @author wujie
 * @Datetime 2017年4月18日 上午11:27:33
 */
class inneUser{
	
	public inneUser(){
		
	}
	
	public inneUser(String flag){
		this.flag=flag;
	}
	
	
	private int id;
	private String name;
	private String flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}