package com.Sia.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月23日
 * @description
 */
@XmlRootElement(name = "Item")
@XmlType(propOrder = { "nodeId", "protocol", "deviceId", "modAddr", "type", "rw", "fre" })
public class Item {
	private int nodeId;
	private int protocol;
	private int deviceId;
	private int modAddr;
	private int type;
	private int rw;
	private int fre;
	private String value;

	public Item() {
		super();
	}

	public Item(int nodeId, int protocol, int deviceId, int modAddr, int type, int rw, int fre) {
		this.nodeId = nodeId;
		this.protocol = protocol;
		this.deviceId = deviceId;
		this.modAddr = modAddr;
		this.type = type;
		this.rw = rw;
		this.fre = fre;
	}

	public int getNodeId() {
		return nodeId;
	}

	@XmlAttribute(name = "NodeID")
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public int getProtocol() {
		return protocol;
	}

	@XmlAttribute(name = "Protocol")
	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}

	public int getDeviceId() {
		return deviceId;
	}

	@XmlAttribute(name = "DeviceID")
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getModAddr() {
		return modAddr;
	}

	@XmlAttribute(name = "ModAddr")
	public void setModAddr(int modAddr) {
		this.modAddr = modAddr;
	}

	public int getType() {
		return type;
	}

	@XmlAttribute(name = "Type")
	public void setType(int type) {
		this.type = type;
	}

	public int getRw() {
		return rw;
	}

	@XmlAttribute(name = "Rw")
	public void setRw(int rw) {
		this.rw = rw;
	}

	public int getFre() {
		return fre;
	}

	@XmlAttribute(name = "Fre")
	public void setFre(int fre) {
		this.fre = fre;
	}

}
