package com.Sia.pojo;

import java.util.List;

import com.Sia.model.Items;
import com.Sia.model.Menus;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月11日
 * @description
 */

public class MenuPlus extends Menus {
	private static final long serialVersionUID = 1L;
	private List<Items> items;

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public MenuPlus(Menus menus, List<Items> items) {
		super();
		this.setId(menus.getId());
		this.setTitle(menus.getTitle());
		this.setIcon(menus.getIcon());
		this.setIsEnable(menus.getIsEnable());
		this.setItems(items);
		this.setAtIndex(menus.getAtIndex());
		this.setAtTime(menus.getAtTime());
	}
}
