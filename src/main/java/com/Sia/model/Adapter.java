package com.Sia.model;

import java.io.Serializable;
import java.util.Date;

public class Adapter implements Serializable {
	private Integer nodeId;

	private Integer gatewayId;

	private String name;

	private String serial;

	private String typeserial;

	private String longAddress;

	private String subAddress;

	private String type;

	private String factory;

	private Integer protoclId;

	private Integer isEnable;

	private Date atTime;

	private static final long serialVersionUID = 1L;

	public Adapter() {
		super();
	}

	public Adapter(int nodeId, int gatewayId, String name, String serial, String typeserial, String longAddress, String subAddress, String type, String factory, int protoclId) {
		this.nodeId = nodeId;
		this.gatewayId = gatewayId;
		this.name = name;
		this.serial = serial;
		this.typeserial = typeserial;
		this.longAddress = longAddress;
		this.subAddress = subAddress;
		this.type = type;
		this.factory = factory;
		this.protoclId = protoclId;
		this.atTime = new Date();
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public Integer getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(Integer gatewayId) {
		this.gatewayId = gatewayId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial == null ? null : serial.trim();
	}

	public String getTypeserial() {
		return typeserial;
	}

	public void setTypeserial(String typeserial) {
		this.typeserial = typeserial == null ? null : typeserial.trim();
	}

	public String getLongAddress() {
		return longAddress;
	}

	public void setLongAddress(String longAddress) {
		this.longAddress = longAddress == null ? null : longAddress.trim();
	}

	public String getSubAddress() {
		return subAddress;
	}

	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress == null ? null : subAddress.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory == null ? null : factory.trim();
	}

	public Integer getProtoclId() {
		return protoclId;
	}

	public void setProtoclId(Integer protoclId) {
		this.protoclId = protoclId;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Date getAtTime() {
		return atTime;
	}

	public void setAtTime(Date atTime) {
		this.atTime = atTime;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Adapter other = (Adapter) that;
		return (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId())) && (this.getGatewayId() == null ? other.getGatewayId() == null : this.getGatewayId().equals(other.getGatewayId()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName())) && (this.getSerial() == null ? other.getSerial() == null : this.getSerial().equals(other.getSerial()))
				&& (this.getTypeserial() == null ? other.getTypeserial() == null : this.getTypeserial().equals(other.getTypeserial())) && (this.getLongAddress() == null ? other.getLongAddress() == null : this.getLongAddress().equals(other.getLongAddress()))
				&& (this.getSubAddress() == null ? other.getSubAddress() == null : this.getSubAddress().equals(other.getSubAddress())) && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getFactory() == null ? other.getFactory() == null : this.getFactory().equals(other.getFactory())) && (this.getProtoclId() == null ? other.getProtoclId() == null : this.getProtoclId().equals(other.getProtoclId()))
				&& (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable())) && (this.getAtTime() == null ? other.getAtTime() == null : this.getAtTime().equals(other.getAtTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
		result = prime * result + ((getGatewayId() == null) ? 0 : getGatewayId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getSerial() == null) ? 0 : getSerial().hashCode());
		result = prime * result + ((getTypeserial() == null) ? 0 : getTypeserial().hashCode());
		result = prime * result + ((getLongAddress() == null) ? 0 : getLongAddress().hashCode());
		result = prime * result + ((getSubAddress() == null) ? 0 : getSubAddress().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getFactory() == null) ? 0 : getFactory().hashCode());
		result = prime * result + ((getProtoclId() == null) ? 0 : getProtoclId().hashCode());
		result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
		result = prime * result + ((getAtTime() == null) ? 0 : getAtTime().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", nodeId=").append(nodeId);
		sb.append(", gatewayId=").append(gatewayId);
		sb.append(", name=").append(name);
		sb.append(", serial=").append(serial);
		sb.append(", typeserial=").append(typeserial);
		sb.append(", longAddress=").append(longAddress);
		sb.append(", subAddress=").append(subAddress);
		sb.append(", type=").append(type);
		sb.append(", factory=").append(factory);
		sb.append(", protoclId=").append(protoclId);
		sb.append(", isEnable=").append(isEnable);
		sb.append(", atTime=").append(atTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}