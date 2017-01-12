package com.Sia.service;

import com.Sia.model.State;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月20日
 * @description
 */

public interface StateService {

	/**
	 * 新增一条状态
	 * 
	 * @param state
	 * @return >1成功
	 */
	int insertSelective(State state);

	/**
	 * 通过NodeID查询一条记录
	 * 
	 * @param nodeId
	 * @return 该条记录
	 */
	State selectByPrimaryKey(int nodeId);

	int deleteByPrimaryKey(int nodeId);
}
