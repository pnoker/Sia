package com.Sia.util.tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月14日
 * @description
 */

public class WeathUtil {
	public String getSignature(String uid, String key) {
		String ts = "" + System.currentTimeMillis() / 1000;
		int ttl = 30;
		String content = "ts=" + ts + "&ttl=" + ttl + "&uid=" + uid;
		String sig = "";
		try {
			byte[] data = key.getBytes("utf-8");
			SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(secretKey);
			byte[] text = content.getBytes("utf-8");
			Base64 base64 = new Base64();
			sig = base64.encodeToString(mac.doFinal(text));
			sig = URLEncoder.encode(sig, "utf-8");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return content + "&sig=" + sig;
	}

	public String getWeatherJson(String location) {
		StringBuffer buffer = new StringBuffer();
		String url = "https://api.thinkpage.cn/v3/weather/now.json?";
		String sig = getSignature("U8E02EB946", "o7iyfv7llsr9yq3q");
		try {
			URL requestUrl = new URL(url + sig + "&location=" + location);
			HttpURLConnection httpURLConnection = (HttpURLConnection) requestUrl.openConnection();
			httpURLConnection.connect();
			InputStream inputStream = httpURLConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			httpURLConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		WeathUtil signatuUtil = new WeathUtil();
		String jsonString = signatuUtil.getWeatherJson("beijing");
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			//JSONObject personObject = jsonObject.getJSONObject("results");
			JSONArray results = jsonObject.getJSONArray("results");
			JSONObject location = results.getJSONObject(0).getJSONObject("location");
			JSONObject  now = results.getJSONObject(0).getJSONObject("now");
			System.out.println(results);
			System.out.println(location);
			System.out.println(now);
			System.out.println(location.get("name"));
			System.out.println(location.get("path"));
			System.out.println(now.get("temperature"));
			System.out.println(now.get("text"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(jsonString);
	}
}
