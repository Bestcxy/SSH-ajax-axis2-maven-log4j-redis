package com.bestcxx.mavenstu.mavenssh.wechat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @theme 微信更新access_token\Jsapiticket的方法
 * @author wujie
 * @Datetime 2017年3月17日 上午11:08:56
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理  
@Rollback(false) 
public class TestWechatUtil {	
	private Logger logger=LogManager.getLogger(TestWechatUtil.class);
	/*private static Logger logger;
	
	@org.junit.Before
	public void Before(){
		logger=LogManager.getLogger(TestWechatUtil.class);
	}*/
	
	/**
	 * 更新accesstoken的测试方法
	 * @instruction
	 * @Datetime 2017年3月17日 下午2:06:07
	 */
	@Test     
	public void forAccesstokenTest(){
		 //Logger logger=LogManager.getLogger(TestWechatUtil.class);
		WechatUtil w=new WechatUtil();
//		String access_token=w.forAccesstoken(EnumUtil.WECHAT_APPID.toString(),EnumUtil.WECHAT_APPSECRET.toString());
		String access_token="MHjo069RuxTo0UsQKSmUXABrhRo2W7vriWJhgQKt9bH1Vr2yvT9HRlDAmYFKleQ03uh1hEOlFDIHpjFp9yxAN_VVK2Fv4x6A-nlKC0tc7qnaJKUc81VBJ96nNdj-nd4GJOJaADARWR";
		logger.info("获得的access_token="+access_token);
				
	}
	
	
   @Test
	public void test2() throws IOException{
	   InputStream inStream = TestWechatUtil.class.getClassLoader().getResourceAsStream("config/jdbc.properties");
	   Properties prop = new Properties();
	   prop.load(inStream);
	  
	   String key = prop.getProperty("jdbc.url");
	//	   System.out.println("key="+key);
	   System.out.println("key="+ prop.size());
	}
    
}
