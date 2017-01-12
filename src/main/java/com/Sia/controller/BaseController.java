package com.Sia.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.alibaba.fastjson.JSON;

public class BaseController {

	protected HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}

	protected HttpSession getSession() {
		return getRequest().getSession(true);
	}

	public String createSimpleSuccessJson(String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "Y");
		map.put("message", message);
		return JSON.toJSONString(map).toString();
	}

	public String createSimpleFailureJson(String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "N");
		map.put("message", message);
		return JSON.toJSONString(map).toString();
	}

	public String createResultJson(String resultCode, String msg, Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result_code", resultCode);
		map.put("msg", msg);
		if (obj != null) {
			map.put("data", JSON.toJSON(obj));
		}
		return JSON.toJSONString(map);
	}

	public String decoderURL(String value) {
		try {
			value = URLDecoder.decode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> parseObject(String jsonStr) {

		if (StringUtils.isEmpty(jsonStr)) {
			return null;
		}
		try {
			Map<String, Object> jsonMap = JSON.parseObject(jsonStr, Map.class);
			return jsonMap;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> parseList(String jsonStr) {
		if (StringUtils.isEmpty(jsonStr)) {
			return null;
		}
		try {
			List<Map<String, Object>> list = JSON.parseObject(jsonStr, List.class);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@ExceptionHandler({ Exception.class })
	public String exception(Exception e) {
		return "/error";
	}
}
