package com.Sia.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月17日
 * @description
 */

public class GridDataResult<T> {
	private int total;
	private List<T> root = new ArrayList<T>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRoot() {
		return root;
	}

	public void setRoot(List<T> root) {
		this.root = root;
	}
}
