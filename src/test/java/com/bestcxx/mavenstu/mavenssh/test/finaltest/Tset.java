package com.bestcxx.mavenstu.mavenssh.test.finaltest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Tset {
	Integer c=1;
	AtomicLong e=new AtomicLong(3);
		
	
	ArrayList<Integer> d=new ArrayList<Integer>();
	public String a="123";
	
	public void b(){
		
	};
	public static void main(String[] args) {
		//
		//==比较的是栈中的地址，equal是堆中的内容
		String a=new String("123");
		String b="123";
		String c=a;//同一个对象，同一个引用
		String d=b;//同一个对象，同一个引用
		String e=c;//一个对象，同一个引用
		
		System.out.println((a==b)+":false 表示两个对象&"+a.equals(b)+":true 表示是同一个引用");
		//System.out.println((a==c)+":false 表示两个对象&"+a.equals(c)+":true 表示是同一个引用");
		//System.out.println((d==b)+":false 表示两个对象&"+d.equals(b)+":true 表示是同一个引用");
		//System.out.println((d==c)+":false 表示两个对象&"+d.equals(c)+":true 表示是同一个引用");
		//System.out.println((e==c)+":false 表示两个对象&"+e.equals(c)+":true 表示是同一个引用");
		
		//String h="123";
		//System.out.println((b==h)+":false 表示两个对象&"+b.equals(h)+":true 表示是同一个引用");
		
	}
	
	
}