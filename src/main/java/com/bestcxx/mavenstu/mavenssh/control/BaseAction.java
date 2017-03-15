package com.bestcxx.mavenstu.mavenssh.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bestcxx.mavenstu.mavenssh.service.PersonService;
import com.bestcxx.mavenstu.mavenssh.util.GenericsUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	private static final long serialVersionUID = 6771037920174222844L;

	protected Class<T> modelClass;
	
	protected T model;
	
	@SuppressWarnings("unchecked")
	public BaseAction() {
		modelClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	}
	
	@Override
	public T getModel() {
		try {
			model = modelClass.newInstance();
		} catch (Exception e) {
			model = null;
		}
		return model;
	}
	
	@Autowired
	protected PersonService personService;
	
	/** AJAX请求返回信息*/
    protected Map<String, Object> message = new HashMap<String, Object>();
    /** AJAX请求返回RESULT的name常量*/
    protected final static String MESSAGE = "message";
	
    /**
     * 向返回信息中添加action的错误信息
     * @return
     */
    public Map<String, Object> getMessage() {
    	message.put("fieldErrors", getFieldErrors());
    	message.put("actionErrors", getActionErrors());
    	message.put("actionMessages", getActionMessages());
    	return message;
    }

}
