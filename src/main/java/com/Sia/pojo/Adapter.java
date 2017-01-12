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
@XmlType(propOrder = { "nodeID", "parentNodeID", "name", "desIp", "desPort", "myIp", "myPort", "pro", "variable" })
public class Adapter {
	private String nodeID;
	private String name;
	private String parentNodeID;
	private String desIp;
	private String desPort;
	private String myIp;
	private String myPort;
	private String pro;
	private List<Variable> variable;

	public Adapter() {
		super();
	}

	public Adapter(String nodeID, String name, String parentNodeID, String desIp, String desPort, String myIp, String myPort, String pro, List<Variable> variable) {
		this.nodeID = nodeID;
		this.name = name;
		this.parentNodeID = parentNodeID;
		this.desIp = desIp;
		this.desPort = desPort;
		this.myIp = myIp;
		this.myPort = myPort;
		this.pro = pro;
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

	public String getDesIp() {
		return desIp;
	}

	@XmlAttribute(name = "DesIP")
	public void setDesIp(String desIp) {
		this.desIp = desIp;
	}

	public String getDesPort() {
		return desPort;
	}

	@XmlAttribute(name = "DesPort")
	public void setDesPort(String desPort) {
		this.desPort = desPort;
	}

	public String getMyIp() {
		return myIp;
	}

	@XmlAttribute(name = "MyIP")
	public void setMyIp(String myIp) {
		this.myIp = myIp;
	}

	public String getMyPort() {
		return myPort;
	}

	@XmlAttribute(name = "MyPort")
	public void setMyPort(String myPort) {
		this.myPort = myPort;
	}

	public String getPro() {
		return pro;
	}

	@XmlAttribute(name = "Pro")
	public void setPro(String pro) {
		this.pro = pro;
	}

	public List<Variable> getVariable() {
		return variable;
	}

	@XmlElement(name = "Variable")
	public void setVariable(List<Variable> variable) {
		this.variable = variable;
	}

}
