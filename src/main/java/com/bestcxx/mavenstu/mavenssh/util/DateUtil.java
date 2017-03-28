package com.bestcxx.mavenstu.mavenssh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DateUtil {
	private static Logger logger=LogManager.getLogger(DateUtil.class);
	
	private static SimpleDateFormat sdf_yyyyMMddHHmmss=new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat sdf_yyyy_MM_dd=new SimpleDateFormat("yyyy/MM/dd");
	
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
	
	/**
	 * 
	 * @instruction 日期格式转为 字符串   2017/03/01
	 * @Datetime 2017年3月28日 上午11:44:16
	 * @param yyyy_MM_dd
	 * @return
	 */
	public static String getStringFromDate_yyyy_MM_dd(Date yyyy_MM_dd){
		return sdf_yyyy_MM_dd.format(yyyy_MM_dd);
	}
	
	/**
	 * 
	 * @instruction 整形时间转为字符串格式的时间，格式为 yyyy/MM/dd
	 * @Datetime 2017年3月28日 上午11:48:33
	 * @param datetime
	 * @return
	 */
	public static String getStringFromDatetime(long datetime){
		Date date=new Date(datetime);
		return getStringFromDate_yyyy_MM_dd(date);
	}
}
