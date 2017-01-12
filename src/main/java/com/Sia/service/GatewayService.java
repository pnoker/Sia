package com.Sia.service;

import java.util.List;

import com.Sia.model.Gateway;
import com.Sia.model.GatewayExample;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月20日
 * @description
 */

public interface GatewayService {

	/**
	 * 新增一条网关记录
	 * 
	 * @param gateway
	 * @return >1成功
	 */
	int insertSelective(Gateway gateway);

	int deleteByPrimaryKey(int nodeId);

	Gateway selectByPrimaryKey(int nodeId);

	int updateByPrimaryKeySelective(Gateway gateway);

	List<Gateway> selectByExample(GatewayExample example);

	int countByExample(GatewayExample example);

}
