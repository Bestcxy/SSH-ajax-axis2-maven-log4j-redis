package com.bestcxx.mavenstu.mavenssh.test;

/*
 * ·测试抽象类包含静态变量以及其实现类和继承类的关系
 * ·涉及到的类有：
 *  TestI20170318.java	StaticInterface.java	StaticInterfaceAgain.java
 *  StaticInterfaceImpl.java	StaticInterfaceThird.java
 *  
 * ·接口类中允许有静态变量，但是不允许有静态方法
 * ·接口类中允许使用 public、abstract 修饰方法
 * 
 * ·接口类中的静态变量不允许继承,同时由于接口类无构造方法而无法修改
 * ·接口类中不允许有具体实现方法
 * 
 * ·在接口实现类（包括普通类和抽象类）中，除了static修饰的静态变量不允许覆盖重写，其他方法会强制覆盖重写
 * ·接口的继承类，必然还是接口，继承类中不会要求强制覆盖任何方法，也没有什么意义，但可以扩充原接口类的方法
 * 
 * ·接口类没有构造方法
 */
public interface StaticInterface {
	
	public static String numbr="123";
	public String number2="456";
	
	public  String M1(String str);
	abstract String M2(String str);
	String M3(String str);
	
}
