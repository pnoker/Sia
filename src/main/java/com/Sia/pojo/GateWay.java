package com.Sia.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月18日
 * @description
 */
@XmlRootElement(name = "GateWay")
@XmlType(propOrder = { "nodeID", "name", "adapter" })
public class GateWay {
	private String nodeID;
	private String name;
	private List<Adapter> adapter;

	public GateWay() {
		super();
	}

	public GateWay(String nodeID, String name, List<Adapter> adapter) {
		this.nodeID = nodeID;
		this.name = name;
		this.adapter = adapter;
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

	public List<Adapter> getAdapter() {
		return adapter;
	}

	@XmlElement(name = "Adapter")
	public void setAdapter(List<Adapter> adapter) {
		this.adapter = adapter;
	}

}
