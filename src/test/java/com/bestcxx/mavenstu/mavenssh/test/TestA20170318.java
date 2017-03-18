package com.bestcxx.mavenstu.mavenssh.test;

import org.junit.Test;

/**
 * 
 * @theme 测试抽象类中静态变量和方法的辩证
 * @author wujie
 * @Datetime 2017年3月18日 下午12:08:38
 */
public class TestA20170318 {
	@Test
	public void test1(){
		AbstractStatic a=new AbstractStaticAgain();
		System.out.println("静态变量中的常量输出："+a.number+"  "+a.number2);
	}
}
