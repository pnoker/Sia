package com.Sia.service;

import java.util.List;

import com.Sia.model.DataReal;
import com.Sia.model.DataRealExample;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月22日
 * @description
 */

public interface DataRealService {

	List<DataReal> selectByExample(DataRealExample example);

	DataReal selectByPrimaryKey(int nodeId);

	int insertSelective(DataReal dataReal);

	int updateByPrimaryKeySelective(DataReal dataReal);

	int deleteByPrimaryKey(int nodeId);

	int countByExample(DataRealExample example);

}
