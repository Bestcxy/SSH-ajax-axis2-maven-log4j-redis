package com.bestcxx.mavenstu.mavenssh.test;

import org.junit.Test;

/**
 * 
 * @theme 无固定主题测试类
 * @author wujie
 * @Datetime 2017年3月18日 上午11:13:02
 */
public class TestI20170318 {
	
	@Test
	public void test1(){
		StaticInterface s=new StaticInterfaceImpl();
		System.out.println("抽象类中的静态变量输出："+s.numbr);
		
	}
}
