package com.bestcxx.mavenstu.mavenssh.control;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

import com.bestcxx.mavenstu.mavenssh.model.Person;

@Controller
@SuppressWarnings("serial") 
public class PersonAction extends BaseAction<Person> {
	/*@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="userName",message="用户名不能为空!"), 
			@RequiredStringValidator(fieldName="passWord",message="密码不能为空!") 
			}, 
			regexFields={@RegexFieldValidator(fieldName="userName",regexExpression="^(\\+86|0|1)\\d{10,11}$", 
			message="用户名格式不正确！")} 
			)*/
	
	public String register(){
		if(personService.addPerson(model)){
			return SUCCESS;
		}
		return INPUT;
	}
	public void validateRegister(){
		if(model.getUserName()==null||model.getPassWord()==""){
			addFieldError("userName", getText("usernamenull"));
		}
		if(!StringUtils.isNotBlank(model.getPassWord())){
			addFieldError("passWord", getText("passwordnull"));
		}
	}
	
	/**
	 * ajax_验证用户名的唯一性
	 */
	public String checkUserName(){
		String msg="该用户名已被注册";
		String result="true";
		if(personService.checkPerson(model)){
			addFieldError("userName", msg);
			result="false";
		}
		message.put("result", result);
		return MESSAGE;
	}
}
