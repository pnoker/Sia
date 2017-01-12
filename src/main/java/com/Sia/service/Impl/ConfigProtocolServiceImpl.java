package com.Sia.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sia.dao.ConfigProtocolMapper;
import com.Sia.model.ConfigProtocol;
import com.Sia.model.ConfigProtocolExample;
import com.Sia.service.ConfigProtocolService;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月23日
 * @description
 */
@Service("configProtocolService")
public class ConfigProtocolServiceImpl implements ConfigProtocolService {
	@Autowired
	private ConfigProtocolMapper configProtocolServiceImpl;

	@Override
	public List<ConfigProtocol> selectByExample(ConfigProtocolExample example) {
		return configProtocolServiceImpl.selectByExample(example);
	}

	@Override
	public ConfigProtocol selectByDataRealId(int dataRealId) {
		return configProtocolServiceImpl.selectByDataRealId(dataRealId);
	}

	@Override
	public int insertSelective(ConfigProtocol configProtocol) {
		return configProtocolServiceImpl.insertSelective(configProtocol);
	}

	@Override
	public int deleteByPrimaryKey(int id) {
		return configProtocolServiceImpl.deleteByPrimaryKey(id);
	}

	@Override
	public ConfigProtocol selectByPrimaryKey(int id) {
		return configProtocolServiceImpl.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ConfigProtocol configProtocol) {
		return configProtocolServiceImpl.updateByPrimaryKeySelective(configProtocol);
	}

}
