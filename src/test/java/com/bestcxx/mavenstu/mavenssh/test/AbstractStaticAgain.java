package com.bestcxx.mavenstu.mavenssh.test;

public class AbstractStaticAgain extends AbstractStatic {

	public AbstractStaticAgain() {
		// TODO Auto-generated constructor stub
		super("1111111111111");
	}
	//抽象类中的抽象方法强制覆盖重写
	@Override
	String M1(String str) {
		// TODO Auto-generated method stub
		return str;
	}
	
	//抽象类中的普通方法可以选择是否覆盖重写
	@Override
	String M2(String str) {
		// TODO Auto-generated method stub
		return super.M2(str);
	}
	
}
