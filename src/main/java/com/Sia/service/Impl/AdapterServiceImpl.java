package com.Sia.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sia.dao.AdapterMapper;
import com.Sia.model.Adapter;
import com.Sia.model.AdapterExample;
import com.Sia.service.AdapterService;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月21日
 * @description
 */
@Service("adapterService")
public class AdapterServiceImpl implements AdapterService {
	@Autowired
	private AdapterMapper adapterMapper;

	@Override
	public int insertSelective(Adapter adapter) {
		return adapterMapper.insertSelective(adapter);
	}

	@Override
	public Adapter selectByPrimaryKey(int nodeId) {
		return adapterMapper.selectByPrimaryKey(nodeId);
	}

	@Override
	public int deleteByPrimaryKey(int nodeId) {
		return adapterMapper.deleteByPrimaryKey(nodeId);
	}

	@Override
	public int updateByPrimaryKeySelective(Adapter adapter) {
		return adapterMapper.updateByPrimaryKeySelective(adapter);
	}

	@Override
	public List<Adapter> selectByExample(AdapterExample example) {
		return adapterMapper.selectByExample(example);
	}

	@Override
	public int countByExample(AdapterExample example) {
		return adapterMapper.countByExample(example);
	}

}
