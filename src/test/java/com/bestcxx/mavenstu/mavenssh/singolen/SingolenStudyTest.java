package com.bestcxx.mavenstu.mavenssh.singolen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * 
 * @theme 单例模式测试-单例类调用普通类，普通类也可以实现单例的效果
 * @author wujie
 * @Datetime 2017年4月25日
 */
public class SingolenStudyTest {
	private static Logger logger = LogManager.getLogger(SingolenStudyTest.class); 
	
	
	@Test
	public void testMethod1(){
		
		
		SingolenStudy.getInstance().method1();
		
		/*注释掉的测试方法和上面效果一致*/
		/*SingolenStudy s=SingolenStudy.getInstance();
		s.method1();
		*/	
		}
	
	@Test
	public void testMethod2(){
		logger.info("\n开始第二次调用，可以看到，单例模式类和单例模式构造方法实例化的普通类都没有再次实例化");
		SingolenStudy.getInstance().method1();
		
		/*注释掉的测试方法和上面效果一致*/
		/*SingolenStudy s=SingolenStudy.getInstance();
		s.method1();*/
		
	}

}
