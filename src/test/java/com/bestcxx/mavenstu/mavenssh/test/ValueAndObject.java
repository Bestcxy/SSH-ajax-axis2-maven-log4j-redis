package com.bestcxx.mavenstu.mavenssh.test;

import org.junit.Test;

import com.bestcxx.mavenstu.mavenssh.model.Person;

//理解String 类型的值引用或者值传递
//与对象引用或者引用传递的区别
// http://blog.csdn.net/morgerton/article/details/54908592
public class ValueAndObject {
	public String returnStr(String str,String strt,Person p){
		str=str+" and "+strt;
		strt=str+"Change";
		p.setUserName("NameChange");
		return str;
	}
	
	@Test
	public void test(){
		String str=new String("one");
		String strt="two";
		Person u=new Person();
		u.setUserName("NameO");
		
		returnStr(str,strt,u);
		System.out.println(str);
		System.out.println(strt);
		System.out.println(u.getUserName());
		
	}

}
