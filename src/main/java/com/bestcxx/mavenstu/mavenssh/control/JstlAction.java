package com.bestcxx.mavenstu.mavenssh.control;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @theme 测试前端展示Jstl的高级用法
 * @author wujie
 * @Datetime 2017年4月11日 下午7:05:57
 */
public class JstlAction extends BaseAction<String> {

	private static final long serialVersionUID = 2745365588965355265L;
	
	private List<String> forEachStr;//前端展示 循环 <c:foreach
	private String containStr;//前端截取字符串
	private String strToIntStr;//前端字符串转为整形
	
	public String jstl(){
		
		//前端展示 循环 <c:foreach
		forEachStr=new ArrayList<String>();
		forEachStr.add("list-1");
		forEachStr.add("list-2");
		forEachStr.add("list-3");
		
		//前端截取字符串
		containStr="Hello World 123";
		
		//前端字符串转为整形
		strToIntStr="100.01";
		
		return SUCCESS;
	}

	
	public List<String> getForEachStr() {
		return forEachStr;
	}


	public void setForEachStr(List<String> forEachStr) {
		this.forEachStr = forEachStr;
	}


	public String getContainStr() {
		return containStr;
	}

	public void setContainStr(String containStr) {
		this.containStr = containStr;
	}

	public String getStrToIntStr() {
		return strToIntStr;
	}

	public void setStrToIntStr(String strToIntStr) {
		this.strToIntStr = strToIntStr;
	}

	
}
