package com.Sia.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sia.dao.WeatherMapper;
import com.Sia.model.Weather;
import com.Sia.service.WeatherService;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月12日
 * @description
 */
@Service("weatherService")
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	private WeatherMapper weatherMapper;

	@Override
	public Weather selectByCode(int code) {
		return weatherMapper.selectByCode(code);
	}

}
