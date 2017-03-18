package com.bestcxx.mavenstu.mavenssh.test;

/*
 * ·涉及到的类 CommonStatic.java	CommonStaticAgain.java
 * ·普通类不允许使用static修饰
 * ·普通类的继承类不会被要求强制覆盖重写任何方法
 * ·普通类的继承类可以选择覆盖重写普通方法，但是不允许覆盖重写静态方法
 * 
 * ·子类可以通过构造方法修改父类的静态常量和普通常量
 * ·普通类通过其子类实例化将具备其子类的特性
 */
public class CommonStatic {
	public static String number="123";
	public String number2="123";
	public CommonStatic() {
		// TODO Auto-generated constructor stub
	}
	
	public CommonStatic(String str) {
		// TODO Auto-generated constructor stub
		this.number=str;
		this.number2=str;
	}
	
	public static String M1(String str){
		return str;
	}
	
	public String M2(String str){
		return str;
	}
}
