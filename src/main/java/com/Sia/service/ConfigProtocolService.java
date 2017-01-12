package com.Sia.service;

import java.util.List;

import com.Sia.model.ConfigProtocol;
import com.Sia.model.ConfigProtocolExample;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月23日
 * @description
 */

public interface ConfigProtocolService {

	List<ConfigProtocol> selectByExample(ConfigProtocolExample example);

	ConfigProtocol selectByDataRealId(int dataRealId);

	int insertSelective(ConfigProtocol configProtocol);

	int deleteByPrimaryKey(int id);

	ConfigProtocol selectByPrimaryKey(int id);

	int updateByPrimaryKeySelective(ConfigProtocol configProtocol);

}
