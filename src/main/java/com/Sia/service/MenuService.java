package com.Sia.service;

import java.util.List;

import com.Sia.pojo.MenuPlus;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月11日
 * @description
 */

public interface MenuService {

	List<MenuPlus> selectByEnable(int enable, int userId);

}
