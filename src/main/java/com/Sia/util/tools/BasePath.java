package com.Sia.util.tools;

import java.io.File;

public class BasePath {
	private String basePath;

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public BasePath() {
		String osName = System.getProperties().getProperty("os.name");
		if (osName.toLowerCase().startsWith("win")) {
			this.basePath = "E:/FileOperation/temp/";
		} else {
			this.basePath = "/home/wangfd/temp/";
		}

		if (!(new File(this.basePath).isDirectory())) {
			System.out.println("文件夹" + basePath);
			new File(this.basePath).mkdirs();
		}

	}

	public static void main(String args[]) {
		String osName = System.getProperties().getProperty("os.name");
		System.out.println(osName);
	}
}
