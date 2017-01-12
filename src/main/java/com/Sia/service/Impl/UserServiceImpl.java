package com.Sia.service.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sia.dao.AuthorMapper;
import com.Sia.dao.UsersMapper;
import com.Sia.model.Author;
import com.Sia.model.Users;
import com.Sia.service.UserService;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月12日
 * @description
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private AuthorMapper authorMapper;

	/*
	 * 通过UserId查找该用户的菜单编号，得到一个String List
	 */
	@Override
	public List<String> selectUserMenuAuthor(int userId) {
		List<String> list = new ArrayList<String>();
		Users user = usersMapper.selectByPrimaryKey(userId);// 通过Id获取用户信息
		Author author = authorMapper.selectByPrimaryKey(user.getAuthorId());// 通过外键author_id获取该用户的权限
		Collections.addAll(list, author.getMenuAuthor().split(","));
		return list;
	}

	@Override
	public Users selectUserNPM(String name) {
		return usersMapper.selectUserNPM(name);
	}

	@Override
	public Users selectByPrimaryKey(int id) {
		return usersMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Users user) {
		return usersMapper.updateByPrimaryKeySelective(user);
	}

}
