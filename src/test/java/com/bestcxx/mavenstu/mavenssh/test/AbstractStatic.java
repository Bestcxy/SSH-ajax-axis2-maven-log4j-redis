package com.bestcxx.mavenstu.mavenssh.test;

/*
 * ·涉及到的类 AbstractStatic.java	AbstractStaticAgain.java
 * ·抽象类不允许使用 static 修饰
 * ·抽象类允许静态变量的存在
 * ·抽象类中不允许使用static修饰抽象方法
 * ·抽象类中允许使用static修饰普通方法
 * ·抽象类中的抽象方法强制覆盖重写
 * ·抽象类中的普通方法可以选择是否覆盖重写
 * ·抽象类中的静态方法，不允许覆盖重写
 * ·抽象类无法被直接实例化，只能通过子类来进行实例化
 * 
 * ·抽象类中的静态变量可以通过给子类提供覆盖重写的构造方法来修改静态变量和普通变量的值
 */
public abstract class AbstractStatic {
	public static String number="123";
	public String number2="123";
	
	public AbstractStatic() {
		// TODO Auto-generated constructor stub
	}
	public AbstractStatic(String str) {
		// TODO Auto-generated constructor stub
		this.number=str;
		this.number2=str;
	}
	
	abstract String M1(String str);
	
	String M2(String str) {
		return str;
	}
	
	static String M3(String str) {
		return str;
	}
}
