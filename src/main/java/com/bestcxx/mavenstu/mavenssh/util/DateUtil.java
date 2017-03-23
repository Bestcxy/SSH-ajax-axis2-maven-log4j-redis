package com.bestcxx.mavenstu.mavenssh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DateUtil {
	private static Logger logger=LogManager.getLogger(DateUtil.class);
	
	private static SimpleDateFormat sdf_yyyyMMddHHmmss=new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static Date getDateFromStr_yyyyMMddHHmmss(String yyyyMMddHHmmss)
	{
		try {
			return sdf_yyyyMMddHHmmss.parse(yyyyMMddHHmmss);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error("字符串转时间异常,字符串需满足格式：yyyyMMddHHmmss ");
		}
		return null;
	}
}
