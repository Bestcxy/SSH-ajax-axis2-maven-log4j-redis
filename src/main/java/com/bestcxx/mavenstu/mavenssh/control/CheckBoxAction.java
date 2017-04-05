package com.bestcxx.mavenstu.mavenssh.control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bestcxx.mavenstu.mavenssh.model.Person;

/**
 * @theme checkbox 测试
 * @author wujie
 * @Datetime 2017年4月5日 上午9:38:01
 */
public class CheckBoxAction extends BaseAction<String>{
	private static final long serialVersionUID = -8665670200211264748L;

	private Logger logger=LogManager.getLogger(CheckBoxAction.class);
	
	private String checkboxStr;

	public String getCheckboxStr() {
		return checkboxStr;
	}

	public void setCheckboxStr(String checkboxStr) {
		this.checkboxStr = checkboxStr;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	/**
	 * @instruction 获取前台传递到后台的 checkbox 字符串 格式如： aaa,bbb,ccc,ddd,eee,fff
	 * @Datetime 2017年4月5日 上午9:39:54
	 */
	public String checkBox(){
		logger.info("前台传递进来的checkbox串为： "+checkboxStr);
		message.put("result", "true");
		return MESSAGE;
	}
	
}
