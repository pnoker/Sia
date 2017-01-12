package com.Sia.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sia.dao.StateMapper;
import com.Sia.model.State;
import com.Sia.service.StateService;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月20日
 * @description
 */
@Service("stateService")
public class StateServiceImpl implements StateService {
	@Autowired
	private StateMapper stateMapper;

	@Override
	public int insertSelective(State state) {
		return stateMapper.insertSelective(state);
	}

	@Override
	public State selectByPrimaryKey(int nodeId) {
		return stateMapper.selectByPrimaryKey(nodeId);
	}

	@Override
	public int deleteByPrimaryKey(int nodeId) {
		return stateMapper.deleteByPrimaryKey(nodeId);
	}

}
