package com.Sia.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sia.dao.OrderDispMapper;
import com.Sia.model.OrderDisp;
import com.Sia.service.OrderDisService;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月27日
 * @description
 */
@Service("orderDisService")
public class OrderDisServiceImpl implements OrderDisService {
	@Autowired
	private OrderDispMapper orderDispMapper;

	@Override
	public int updateByPrimaryKeySelective(OrderDisp orderDisp) {
		return orderDispMapper.updateByPrimaryKeySelective(orderDisp);
	}

}
