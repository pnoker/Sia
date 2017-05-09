package com.Sia.util.tools;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2017年1月2日
 * @description 文件基础路径
 */
public class BasePath {
	static final Logger logger = LogManager.getLogger(BasePath.class);
	private String basePath;

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public BasePath() {
		String osName = System.getProperties().getProperty("os.name");
		logger.info("当前系统为:" + osName);
		if (osName.toLowerCase().startsWith("win")) {
			this.basePath = "E:/FileOperation/opcConfig/";
		} else {
			this.basePath = "/home/FileOperation/opcConfig/";
		}

		if (!(new File(this.basePath).isDirectory())) {
			logger.info("创建文件夹:" + this.basePath);
			new File(this.basePath).mkdirs();
			logger.info("文件夹创建成功！");
		}
	}

	public static void main(String args[]) {
		String osName = System.getProperties().getProperty("os.name");
		System.out.println(osName);
	}
}
