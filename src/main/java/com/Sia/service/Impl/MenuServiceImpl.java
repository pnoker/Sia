package com.Sia.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sia.dao.ItemsMapper;
import com.Sia.dao.MenusMapper;
import com.Sia.model.Items;
import com.Sia.model.Menus;
import com.Sia.pojo.MenuPlus;
import com.Sia.service.MenuService;
import com.Sia.service.UserService;
import com.alibaba.druid.sql.ast.expr.SQLCaseExpr.Item;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月11日
 * @description
 */
@Service("menuServer")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenusMapper menuMapper;
	@Autowired
	private ItemsMapper itemsMapper;
	@Autowired
	private UserService userService;

	@Override
	public List<MenuPlus> selectByEnable(int enable, int userId) {
		List<MenuPlus> menuPlus = new ArrayList<MenuPlus>();
		List<Menus> menus = menuMapper.selectByEnable(enable);
		List<String> list = userService.selectUserMenuAuthor(userId);
		for (int m = 0; m < menus.size(); m++) {
			int parentId = menus.get(m).getId();
			List<Items> items = itemsMapper.selectByParentId(parentId);
			Iterator<Items> iterator = items.iterator();// 创建一个迭代器
			while (iterator.hasNext()) {
				Items item = iterator.next();
				if (!list.contains("" + item.getId())) {
					iterator.remove();
				}
			}
			if (items.size() > 0) {
				menuPlus.add(new MenuPlus(menus.get(m), items));
			}
		}

		return menuPlus;
	}

}
