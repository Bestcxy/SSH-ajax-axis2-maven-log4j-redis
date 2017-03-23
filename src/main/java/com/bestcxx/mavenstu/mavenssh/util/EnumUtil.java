package com.bestcxx.mavenstu.mavenssh.util;

/**
 * @theme 枚举类-设置静态变量
 * @author wujie
 */
public enum EnumUtil {
	//可以以逗号间隔  
	COMMON_DATABASE_PROPERTIES("config/jdbc.properties"),
	COMMON_ENCODING("utf-8"),
	FILE_TXT_PATH("src/main/webapp/WEB-INF/file/filetxt.txt"),//src/main/resources/file/filetxt.txt 也是可以的，都是相对路径
	WECHAT_APPID("appid"),				   	//微信公众号平台账户的appid
	WECHAT_APPSECRET("appsecret"), //微信公众号平台账户的appsecret
	PROXY_SERVICEPORT_SHEZHI("0"),     //代理设置-是否启用代理，0-NO,1-YES
	PROXY_PROXYHOST("192.168.1.1"),    //代理设置-代理IP
	PROXY_PROXYPORT("8080");    	  //代理设置-代理端口
	
      
    private String temStr;  
    private EnumUtil(String temStr){  
        this.temStr=temStr;  
    }  
    @Override  
    public String toString() {
        return String.valueOf (this.temStr);  
    }  
}
