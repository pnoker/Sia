package com.Sia.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月18日
 * @description
 */
@XmlRootElement(name = "Variable")
@XmlType(propOrder = { "nodeID", "parentNodeID", "name", "type", "writable", "item" })
public class Variable {
	private String nodeID;
	private String name;
	private String type;
	private String writable;
	private String parentNodeID;
	private Item item;

	public Variable() {
		super();
	}

	public Variable(String nodeID, String name, String type, String writable, String parentNodeID, Item item) {
		this.nodeID = nodeID;
		this.name = name;
		this.type = type;
		this.writable = writable;
		this.parentNodeID = parentNodeID;
		this.item = item;
	}

	public String getNodeID() {
		return nodeID;
	}

	@XmlAttribute(name = "NodeID")
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}

	public String getName() {
		return name;
	}

	@XmlAttribute(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	@XmlAttribute(name = "type")
	public void setType(String type) {
		this.type = type;
	}

	public String getWritable() {
		return writable;
	}

	@XmlAttribute(name = "writable")
	public void setWritable(String writable) {
		this.writable = writable;
	}

	public String getParentNodeID() {
		return parentNodeID;
	}

	@XmlAttribute(name = "ParentNodeID")
	public void setParentNodeID(String parentNodeID) {
		this.parentNodeID = parentNodeID;
	}

	public Item getItem() {
		return item;
	}

	@XmlElement(name = "Item")
	public void setItem(Item item) {
		this.item = item;
	}

}
