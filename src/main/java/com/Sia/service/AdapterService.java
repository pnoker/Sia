package com.Sia.service;

import java.util.List;

import com.Sia.model.Adapter;
import com.Sia.model.AdapterExample;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月21日
 * @description
 */

public interface AdapterService {

	int insertSelective(Adapter adapter);

	Adapter selectByPrimaryKey(int nodeId);

	int deleteByPrimaryKey(int nodeId);

	int updateByPrimaryKeySelective(Adapter adapter);

	List<Adapter> selectByExample(AdapterExample example);

	int countByExample(AdapterExample example);

}
