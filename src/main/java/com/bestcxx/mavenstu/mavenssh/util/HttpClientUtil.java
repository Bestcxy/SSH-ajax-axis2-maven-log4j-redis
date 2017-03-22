package com.bestcxx.mavenstu.mavenssh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 
 * @theme httpclient的公共类-允许使用代理设置
 * @author wujie
 * @Datetime 2017年3月17日 上午11:01:56
 */
public class HttpClientUtil {
	public static Logger logger = LogManager.getLogger(HttpClientUtil.class); 	    
	 /** 
     * 仅仅在发送url的时候调用 
     * @param url 
     * @return 
     */  
    public static String sendHttpURLConnection(String url){ 
    	logger.info("HttpClientUtil sendHttpURLConnection 发送的url为："+url);  
        String str = "";  
        try {  
            URL getUrl = new URL(url);  
            // 根据拼凑的URL，打开连接，URL.openConnection函数会根据URL的类型，   
            HttpURLConnection connection;  

            //代理判断，0-不使用代理；1-使用代理  
            if("0".equals(EnumUtil.PROXY_SERVICEPORT_SHEZHI.toString())){  
                connection = (HttpURLConnection) getUrl.openConnection();  
            }else{  
                  
                Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP,new InetSocketAddress(EnumUtil.PROXY_PROXYHOST.toString(), Integer.valueOf(EnumUtil.PROXY_PROXYPORT.toString())));  
                connection =(HttpURLConnection)getUrl.openConnection(proxy);   
            }  
              
            // 进行连接，但是实际上get request要在下一句的connection.getInputStream()函数中才会真正发到 
            connection.setConnectTimeout(25000);  
            connection.setReadTimeout(25000);  
            connection.connect();  
            
            // 取得输入流，并使用Reader读取  
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));  
            String lines;  

            //获取返回的字符流转化为字符串  
            while ((lines = reader.readLine()) != null) {  
                str = str + lines;  
            }  

            reader.close();  
            // 断开连接  
            connection.disconnect();   
              
            return str;  

        } catch (IOException e) {  
            // TODO Auto-generated catch block   
            logger.info("HttpClientUtil sendHttpURLConnection 请求出现异常，异常信息为：\n"+str,e.getMessage());  
        }  
        //运行到此说明发生错误  
        str="errcode";  
        return str;  
    }  

}
