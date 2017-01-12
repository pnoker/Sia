package com.Sia.service;

import java.util.List;

import com.Sia.model.DataBase;
import com.Sia.model.DataBaseExample;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月17日
 * @description
 */

public interface DataBaseService {

	List<DataBase> selectByExample(DataBaseExample example);

	int countByExample(DataBaseExample example);

}
