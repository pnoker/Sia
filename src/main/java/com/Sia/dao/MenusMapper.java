package com.Sia.dao;

import java.util.List;

import com.Sia.model.Menus;

public interface MenusMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Menus record);

	int insertSelective(Menus record);

	Menus selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Menus record);

	int updateByPrimaryKey(Menus record);

	List<Menus> selectByEnable(int enable);
}