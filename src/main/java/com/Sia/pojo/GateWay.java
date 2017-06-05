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
@XmlType(propOrder = { "nodeID", "name", "desIp", "desPort", "myIp", "myPort", "pro", "adapter" })
public class GateWay {
	private String nodeID;
	private String name;
	private String desIp;
	private String desPort;
	private String myIp;
	private String myPort;
	private String pro;
	private List<Adapter> adapter;

	public GateWay() {
		super();
	}

	public GateWay(String nodeID, String name, List<Adapter> adapter) {
		this.nodeID = nodeID;
		this.name = name;
		this.adapter = adapter;
	}

	public GateWay(String nodeID, String name, String desIp, String desPort, String myIp, String myPort, String pro, List<Adapter> adapter) {
		this.nodeID = nodeID;
		this.name = name;
		this.desIp = desIp;
		this.desPort = desPort;
		this.myIp = myIp;
		this.myPort = myPort;
		this.pro = pro;
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

	public List<Adapter> getAdapter() {
		return adapter;
	}

	@XmlElement(name = "Adapter")
	public void setAdapter(List<Adapter> adapter) {
		this.adapter = adapter;
	}

}
