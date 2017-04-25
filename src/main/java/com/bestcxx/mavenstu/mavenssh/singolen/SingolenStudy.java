package com.bestcxx.mavenstu.mavenssh.singolen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @theme 单例模式
 * @author wujie
 * @Datetime 2017年4月25日 
 * java 单例的实现方式:http://www.cnblogs.com/hupp/p/4487521.html
 * 
 * Desc:使用静态内部类实现单例模式，单例类内部通过构造方法实例化其他普通类，
 * 实验证明，普通类也实现了单例调用的效果
 * 
 */
public class SingolenStudy {
	private static Logger logger = LogManager.getLogger(SingolenStudy.class); 

	private AnotherCommonClass a;
	private SingolenStudy(){
		logger.info("\nSingolenStudy.java 被实例化");
		 a=new AnotherCommonClass();
	}
	
	private static class SingletonHolder{
        private final static SingolenStudy instance=new SingolenStudy();
    }
	
	public static SingolenStudy getInstance(){
        return SingletonHolder.instance;
    }
	
	//添加该类的其他方法
	public void method1(){
		logger.info("\nSingolenStudy.java 的方法 method1");
		a.method2();
	}
	
	

}
