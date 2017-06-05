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
@XmlRootElement(name = "Adapter")
@XmlType(propOrder = { "nodeID", "parentNodeID", "name", "variable" })
public class Adapter {
	private String nodeID;
	private String name;
	private String parentNodeID;
	private List<Variable> variable;

	public Adapter() {
		super();
	}

	public Adapter(String nodeID, String name, String parentNodeID, List<Variable> variable) {
		this.nodeID = nodeID;
		this.name = name;
		this.parentNodeID = parentNodeID;
		this.variable = variable;
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

	public String getParentNodeID() {
		return parentNodeID;
	}

	@XmlAttribute(name = "ParentNodeID")
	public void setParentNodeID(String parentNodeID) {
		this.parentNodeID = parentNodeID;
	}

	public List<Variable> getVariable() {
		return variable;
	}

	@XmlElement(name = "Variable")
	public void setVariable(List<Variable> variable) {
		this.variable = variable;
	}

}
