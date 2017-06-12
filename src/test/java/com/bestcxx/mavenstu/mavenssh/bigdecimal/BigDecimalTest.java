package com.bestcxx.mavenstu.mavenssh.bigdecimal;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest {
	
	/**
	 * 测试 BigDecimal 加法
	 * @instruction
	 * @Datetime 2017年6月12日 下午2:56:26
	 */
	@Test
	public void testBigDecimalAdd(){
		BigDecimal a=new BigDecimal("0.01");
		BigDecimal b=new BigDecimal("0.01");
		BigDecimal c=a.add(b);
		a=a.add(b);
		System.out.println("c="+c.toString());
		System.out.println("a="+a.toString());
		
	}

}
