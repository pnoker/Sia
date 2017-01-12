package com.Sia.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sia.dao.DataRealMapper;
import com.Sia.model.DataReal;
import com.Sia.model.DataRealExample;
import com.Sia.service.DataRealService;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月22日
 * @description
 */
@Service("dataRealService")
public class DataRealServiceImpl implements DataRealService {
	@Autowired
	private DataRealMapper dataRealMapper;

	@Override
	public List<DataReal> selectByExample(DataRealExample example) {
		return dataRealMapper.selectByExample(example);
	}

	@Override
	public DataReal selectByPrimaryKey(int nodeId) {
		return dataRealMapper.selectByPrimaryKey(nodeId);
	}

	@Override
	public int insertSelective(DataReal dataReal) {
		return dataRealMapper.insertSelective(dataReal);
	}

	@Override
	public int updateByPrimaryKeySelective(DataReal dataReal) {
		return dataRealMapper.updateByPrimaryKeySelective(dataReal);
	}

	@Override
	public int deleteByPrimaryKey(int nodeId) {
		return dataRealMapper.deleteByPrimaryKey(nodeId);
	}

	@Override
	public int countByExample(DataRealExample example) {
		return dataRealMapper.countByExample(example);
	}

}
