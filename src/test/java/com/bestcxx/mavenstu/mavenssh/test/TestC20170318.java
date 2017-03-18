package com.bestcxx.mavenstu.mavenssh.test;

import org.junit.Test;

public class TestC20170318 {
	
	@Test
	public void test1(){
		CommonStatic c=new CommonStatic();
		System.out.println("直接调用父类的静态变量="+c.number+"  "+c.number2);
		
		CommonStaticAgain c2=new CommonStaticAgain();
		System.out.println("直接调用子类的静态变量="+c2.number+"  "+c2.number2);
		
		CommonStatic c3=new CommonStaticAgain();
		System.out.println("父类被子类实现="+c3.number+"  "+c3.number2);
		
	}

}
