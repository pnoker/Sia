package com.Sia.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月18日
 * @description
 */
@XmlRootElement(name = "OpcUaNodes")
@XmlType(propOrder = { "gateWay" })
public class OpcUaNodes {
	private List<GateWay> gateWay;

	public OpcUaNodes() {
		super();
	}

	public OpcUaNodes(List<GateWay> gateWay) {
		this.gateWay = gateWay;
	}

	public List<GateWay> getGateWay() {
		return gateWay;
	}

	@XmlElement(name = "GateWay")
	public void setGateWay(List<GateWay> gateWay) {
		this.gateWay = gateWay;
	}

}
