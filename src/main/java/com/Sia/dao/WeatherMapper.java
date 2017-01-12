package com.Sia.dao;

import com.Sia.model.Weather;

public interface WeatherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Weather record);

    int insertSelective(Weather record);

    Weather selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weather record);

    int updateByPrimaryKey(Weather record);

	Weather selectByCode(int code);
}