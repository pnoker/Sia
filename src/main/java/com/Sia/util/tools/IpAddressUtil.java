package com.Sia.util.tools;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月14日
 * @description
 */

public class IpAddressUtil {
	/**
	 * 获取客户端主机的真实ip地址
	 * 
	 * @param request
	 * @return ip
	 */
	public String getRealIp(HttpServletRequest request) {
		String ip = request.getHeader(" x-forwarded-for ");
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getHeader(" Proxy-Client-IP ");
		}
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getHeader(" WL-Proxy-Client-IP ");
		}
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 主机用localhost访问时，ip为0:0:0:0:0:0:0:1
		if ("0:0:0:0:0:0:0:1".equals(ip)) {
			ip = "localhost";
		}
		return ip;
	}
}
