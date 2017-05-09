package com.Sia.util.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月23日
 * @description
 */

public class HttpClientUtil {
	static final Logger logger = LogManager.getLogger(HttpClientUtil.class);// 日志

	public void doGet(String ip, int port, String url, String name, String text) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		BasePath basePath = new BasePath();
		// 创建httppost
		HttpPost httppost = new HttpPost("http://" + ip + ":" + port + url + ".do");
		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("text", text));
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			logger.info("正在执行请求：" + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream inputStream = entity.getContent();
				String string = convertStreamToString(inputStream);
				logger.info("content : \n" + string);
				File file = new File(basePath.getBasePath(), name + ".xml");
				file.createNewFile();
				byte temp[] = new byte[1024];
				temp = string.getBytes("UTF-8");
				try {
					FileOutputStream fileOutputStream = new FileOutputStream(file);
					fileOutputStream.write(temp, 0, temp.length);
					fileOutputStream.close();
				} catch (FileNotFoundException e) {
					logger.error(e.getMessage());
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
			response.close();
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
	}

	public String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
