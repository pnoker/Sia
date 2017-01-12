package com.Sia.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sia.dao.DataBaseMapper;
import com.Sia.model.DataBase;
import com.Sia.model.DataBaseExample;
import com.Sia.service.DataBaseService;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月17日
 * @description
 */
@Service("dataBaseService")
public class DataBaseServiceImpl implements DataBaseService {
	@Autowired
	private DataBaseMapper dataBaseMapper;

	@Override
	public List<DataBase> selectByExample(DataBaseExample example) {
		return dataBaseMapper.selectByExample(example);
	}

	@Override
	public int countByExample(DataBaseExample example) {
		return dataBaseMapper.countByExample(example);
	}

}
