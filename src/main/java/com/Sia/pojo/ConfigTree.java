package com.Sia.pojo;

import java.util.ArrayList;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月22日
 * @description
 */

public class ConfigTree {
	private boolean leaf;// 叶子结点
	private boolean expanded;// 展开
	private String icon;// 显示图标
	private String nodeId;// 节点ID
	private String parentNodeId;// 父节点ID
	private String name;// 名称
	private ArrayList<ConfigTree> children;

	public ConfigTree() {
		super();
	}

	/**
	 * 用于初始化根节点
	 * 
	 * @param icon
	 * @param name
	 * @param expanded
	 * @param leaf
	 */
	public ConfigTree(String icon, String name, boolean expanded, boolean leaf) {
		this.icon = "/Sia/images/icon/" + icon + ".png";
		this.name = name;
		this.expanded = expanded;
		this.leaf = leaf;
		this.children = new ArrayList<ConfigTree>();
	}

	/**
	 * 用于初始化叶节点变量
	 * 
	 * @param icon
	 * @param name
	 * @param expanded
	 * @param leaf
	 * @param nodeId
	 * @param parentId
	 */
	public ConfigTree(String icon, String name, boolean expanded, boolean leaf, String nodeId, String parentNodeId) {
		this.icon = "/Sia/images/icon/" + icon + ".png";
		this.name = name;
		this.expanded = expanded;
		this.leaf = leaf;
		this.nodeId = nodeId;
		this.parentNodeId = parentNodeId;
	}

	/**
	 * 永远初始化网关节点
	 * 
	 * @param icon
	 * @param name
	 * @param expanded
	 * @param leaf
	 * @param nodeId
	 * @param children
	 */
	public ConfigTree(String icon, String name, boolean expanded, boolean leaf, String nodeId, ArrayList<ConfigTree> children) {
		this.icon = "/Sia/images/icon/" + icon + ".png";
		this.name = name;
		this.expanded = expanded;
		this.leaf = leaf;
		this.nodeId = nodeId;
		this.children = children;
	}

	/**
	 * 用于初始化适配器节点
	 * 
	 * @param icon
	 * @param name
	 * @param expanded
	 * @param leaf
	 * @param nodeId
	 * @param parentId
	 * @param children
	 */
	public ConfigTree(String icon, String name, boolean expanded, boolean leaf, String nodeId, String parentNodeId, ArrayList<ConfigTree> children) {
		this.icon = "/Sia/images/icon/" + icon + ".png";
		this.name = name;
		this.expanded = expanded;
		this.leaf = leaf;
		this.nodeId = nodeId;
		this.parentNodeId = parentNodeId;
		this.children = children;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getParentNodeId() {
		return parentNodeId;
	}

	public void setParentNodeId(String parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ConfigTree> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<ConfigTree> children) {
		this.children = children;
	}

}
