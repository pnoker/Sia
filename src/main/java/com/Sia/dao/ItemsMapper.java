package com.Sia.dao;

import java.util.List;

import com.Sia.model.Items;

public interface ItemsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Items record);

	int insertSelective(Items record);

	Items selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Items record);

	int updateByPrimaryKey(Items record);

	List<Items> selectByParentId(int parentId);
}