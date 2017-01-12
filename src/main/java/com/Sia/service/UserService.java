package com.Sia.service;

import java.util.List;

import com.Sia.model.Users;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月12日
 * @description
 */

public interface UserService {

	List<String> selectUserMenuAuthor(int userId);

	Users selectUserNPM(String name);

	Users selectByPrimaryKey(int id);

	int updateByPrimaryKeySelective(Users user);
}