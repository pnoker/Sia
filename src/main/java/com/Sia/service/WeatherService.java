package com.Sia.service;

import com.Sia.model.Weather;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月12日
 * @description
 */

public interface WeatherService {

	Weather selectByCode(int code);

}
