package com.Sia.pojo;

import java.util.ArrayList;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月16日
 * @description
 */

public class TreeStore {
	private String mtype;
	private String name;
	private boolean leaf;
	private boolean expanded;
	private ArrayList<TreeStore> children;

	public TreeStore(String mtype, String name, boolean leaf, boolean expanden) {
		this.mtype = mtype;
		this.name = name;
		this.leaf = leaf;
		this.expanded = expanden;
	}

	public TreeStore(String mtype, String name, boolean leaf, boolean expanden, ArrayList<TreeStore> children) {
		this.mtype = mtype;
		this.name = name;
		this.leaf = leaf;
		this.expanded = expanden;
		this.children = children;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public ArrayList<TreeStore> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<TreeStore> children) {
		this.children = children;
	}

}
