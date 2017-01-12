package com.Sia.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sia.dao.GatewayMapper;
import com.Sia.model.Gateway;
import com.Sia.model.GatewayExample;
import com.Sia.service.GatewayService;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月20日
 * @description
 */
@Service("gatewayService")
public class GatewayServiceImpl implements GatewayService {
	@Autowired
	private GatewayMapper gatewayMapper;

	@Override
	public int insertSelective(Gateway gateway) {
		return gatewayMapper.insertSelective(gateway);
	}

	@Override
	public int deleteByPrimaryKey(int nodeId) {
		return gatewayMapper.deleteByPrimaryKey(nodeId);
	}

	@Override
	public Gateway selectByPrimaryKey(int nodeId) {
		return gatewayMapper.selectByPrimaryKey(nodeId);
	}

	@Override
	public int updateByPrimaryKeySelective(Gateway gateway) {
		return gatewayMapper.updateByPrimaryKeySelective(gateway);
	}

	@Override
	public List<Gateway> selectByExample(GatewayExample example) {
		return gatewayMapper.selectByExample(example);
	}

	@Override
	public int countByExample(GatewayExample example) {
		return gatewayMapper.countByExample(example);
	}

}
