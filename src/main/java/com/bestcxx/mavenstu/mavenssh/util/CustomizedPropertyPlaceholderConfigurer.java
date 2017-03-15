package com.bestcxx.mavenstu.mavenssh.util;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 自定义PropertyPlaceholderConfigurer返回properties内容
 * Spring的applicationContext.xml的
 * <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
 * 需要改变为
 * <bean class="本类路径.CustomizedPropertyPlaceholderConfigurer">
 */

public class CustomizedPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private static Map<String, String> ctxPropertiesMap;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		ctxPropertiesMap = new HashMap<String, String>();
		
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	public static String getContextProperty(String name) {
		return ctxPropertiesMap.get(name);
	}

}
