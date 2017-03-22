package com.bestcxx.mavenstu.mavenssh.wechat;

import java.net.InetAddress;
import java.net.UnknownHostException;  
import java.text.SimpleDateFormat;  
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bestcxx.mavenstu.mavenssh.util.EnumUtil;
import com.bestcxx.mavenstu.mavenssh.util.HttpClientUtil;

import net.sf.json.JSONObject;  

/**
 * @theme 微信更新access_token\Jsapiticket的方法
 * @author wujie
 * @Datetime 2017年3月17日 上午11:08:56
 */
public class WechatUtil {
	public static Logger logger =LogManager.getLogger(WechatUtil.class); 
	 /* 
     * 定时任务调用的主方法-仅允许一台服务器运行，需要进行ip限制 
     */  
    public void updateAccesstokenTask() throws UnknownHostException{  
             
        String ip = (InetAddress.getLocalHost().getHostAddress()==null?"0.0.0.0":InetAddress.getLocalHost().getHostAddress());  
        //将定时任务只放在指定服务器上执行，新增服务器不执行定时任务。  
        String triggerIp="";
        if(!ip.equals(triggerIp)){//如果服务器IP和指定IP不相等，不执行定时任务，  ！是必要的  
            logger.info("本服务器IP为【"+ip+"】,与指定服务器IP【"+triggerIp+"】不符，不执行定时更新accesstoken和jsapi_ticket的服务");  
                  
        }else{  
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            logger.info("运行了定时任务"+sdf.format(new Date()));  
            
            String appid=EnumUtil.WECHAT_APPID.toString();  
            String appsecret=EnumUtil.WECHAT_APPSECRET.toString();//appsecret  
              
            logger.info("appid="+appid+"  appsecret=**********");  
            String accesstoken="";  
            String jsapiticket="";  
              
            accesstoken=forAccesstoken(appid,appsecret);  
            logger.info("accesstoken="+accesstoken);  
            if(!"limit".equals(accesstoken.trim())){  
                jsapiticket=forJsapiticket(accesstoken);  
                  
                if(!"limit".equals(jsapiticket.trim())){  
                	 logger.info("jsapiticket="+jsapiticket);  
                    //查询实体-更新accesstoken-更新jsapiticket  
                    if(true){//这里换成保存数据库的动作!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  
                    	 logger.info("database更新-success");  
                    }else{  
                    	 logger.info("database更新-false");  
                    }  
                  
                }else{  
                	 logger.info("定时任务失败,jsapiticket获取失败");  
                }  
            }else{  
            	 logger.info("定时任务失败,accesstoken获取失败");  
            }  
  
              
        }  
  
          
          
                  
          
    }  
      
    /* 
     * 更新accesstoken的方法 
     */  
    public String  forAccesstoken(String appid,String appsecret){  
          
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appsecret;  
          
        //调用微信更新accesstoken接口  
        String result=HttpClientUtil.sendHttpURLConnection(url);  
        if(result==""||result==null){  
            //如果是交互不正常，那么就继续交互  
             forAccesstoken(appid,appsecret);  
        }  
        if(result.indexOf("errcode")==-1){  
            //说明和微信交互正常  
              
            //判断是否获取到正确的结果  
            JSONObject jsons = JSONObject.fromObject(result);  
              
            if((String)jsons.get("access_token")!=null){  
                String accesstoken="";  
                accesstoken=(String)jsons.get("access_token");  
                return accesstoken;  
            }  
        }else{  
             logger.info("定时任务获取accesstoken异常="+result);  
        }  
          
        return "limit";  
    }  
    /* 
     *更新 jsapi_ticket的方法 
     *https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi 
     */  
      
        public String  forJsapiticket(String ACCESS_TOKEN){  
          
        String url="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ACCESS_TOKEN+"&type=jsapi";  
          
        //调用微信更新forJsapiticket接口  
        String result=HttpClientUtil.sendHttpURLConnection(url);  
        if(result==""||result==null){  
            //如果是交互不正常，那么就继续交互  
            forJsapiticket(ACCESS_TOKEN);  
        }  
        if(result.indexOf("ticket")>-1){  
            //说明和微信交互正常  
              
            //判断是否获取到正确的结果  
            JSONObject jsons = JSONObject.fromObject(result);  
              
            if((String)jsons.get("ticket")!=null){  
                String ticket="";  
                ticket=(String)jsons.get("ticket");  
                return ticket;  
            }  
        }else{  
            //如果是交互不正常，那么就继续交互  
        	logger.info("定时任务获取Jsapiticket异常="+result);  
        }  
          
        return "limit";  
    }  
    
    //https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN
    public String getBatchget_material(){
    	return null;
    }
}
