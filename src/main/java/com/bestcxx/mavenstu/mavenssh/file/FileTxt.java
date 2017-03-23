package com.bestcxx.mavenstu.mavenssh.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestcxx.mavenstu.mavenssh.model.FileTxtModel;
import com.bestcxx.mavenstu.mavenssh.service.FileTxtModelService;
import com.bestcxx.mavenstu.mavenssh.util.DateUtil;
import com.bestcxx.mavenstu.mavenssh.util.EnumUtil;

/**
 * 
 * @theme 对txt文件进行按行、列操作
 * @author wujie
 * @Datetime 2017年3月23日 上午10:26:12
 */
public class FileTxt {
	private static Logger logger = LogManager.getLogger(FileTxt.class);
	@Autowired
	private FileTxtModelService fileTxtModelService;
	
	public FileTxt(){
		
	}
	public FileTxt(FileTxtModelService fileTxtModelService){
		this.fileTxtModelService=fileTxtModelService;
	}

	String filePath = EnumUtil.FILE_TXT_PATH.toString();// 文本路径
	String encoding = EnumUtil.COMMON_ENCODING.toString();// 编码格式

	public void ReadFileTxt() {
		File txtFile = new File(filePath);// 读取文件
		InputStream in = null;
		InputStreamReader read = null;
		BufferedReader reader = null;
		try {
			in = new FileInputStream(txtFile);
			read = new InputStreamReader(in, encoding);// 构建文件缓存
			reader = new BufferedReader(read);

			String temLine = "";// 每一行的内容

			// 默认输出前两行
			logger.info("第一行：" + reader.readLine());
			logger.info("第二行：" + reader.readLine());

			// 循环遍历txt文件
			while ((temLine = reader.readLine()) != null) {
				String[] split = temLine.split("\\s");// 以多个空格作为分隔符
				for (String tem : split) {
					logger.info(tem);
				}
				FileTxtModel fileTxtModel = new FileTxtModel();
				fileTxtModel.setIdentifier(split[0]);
				fileTxtModel.setPrice(new BigDecimal(split[1]));
				fileTxtModel.setDateTime(DateUtil.getDateFromStr_yyyyMMddHHmmss(split[2]));
				fileTxtModel.setName(split[3]);

				fileTxtModelService.add(fileTxtModel);

			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (read != null) {
					read.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
