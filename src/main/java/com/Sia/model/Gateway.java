package com.Sia.model;

import java.io.Serializable;
import java.util.Date;

public class Gateway implements Serializable {
	private Integer nodeId;

	private String name;

	private String ip;

	private Integer port;

	private Integer isEnable;

	private Date atTime;

	private static final long serialVersionUID = 1L;

	public Gateway() {
		super();
	}

	public Gateway(int nodeId, String name, String ip, int port) {
		this.nodeId = nodeId;
		this.name = name;
		this.ip = ip;
		this.port = port;
		this.atTime = new Date();
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
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
		Gateway other = (Gateway) that;
		return (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId())) && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName())) && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
				&& (this.getPort() == null ? other.getPort() == null : this.getPort().equals(other.getPort())) && (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()))
				&& (this.getAtTime() == null ? other.getAtTime() == null : this.getAtTime().equals(other.getAtTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
		result = prime * result + ((getPort() == null) ? 0 : getPort().hashCode());
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
		sb.append(", name=").append(name);
		sb.append(", ip=").append(ip);
		sb.append(", port=").append(port);
		sb.append(", isEnable=").append(isEnable);
		sb.append(", atTime=").append(atTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}