package com.Sia.model;

import java.io.Serializable;
import java.util.Date;

public class ConfigProtocol implements Serializable {
	private Integer id;

	private String name;

	private Integer dataRealId;

	private Integer deviceId;

	private Integer modAddr;

	private Integer type;

	private Integer rw;

	private Integer fre;

	private Date atTime;

	private static final long serialVersionUID = 1L;

	public ConfigProtocol() {
		super();
	}

	public ConfigProtocol(String name, int dataRealId, int deviceId, int modAddr, int type, int rw, int fre) {
		this.name = name;
		this.dataRealId = dataRealId;
		this.deviceId = deviceId;
		this.modAddr = modAddr;
		this.type = type;
		this.rw = rw;
		this.fre = fre;
		this.atTime = new Date();
	}

	public ConfigProtocol(int id, String name, int dataRealId, int deviceId, int modAddr, int type, int rw, int fre) {
		this.id = id;
		this.name = name;
		this.dataRealId = dataRealId;
		this.deviceId = deviceId;
		this.modAddr = modAddr;
		this.type = type;
		this.rw = rw;
		this.fre = fre;
		this.atTime = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getDataRealId() {
		return dataRealId;
	}

	public void setDataRealId(Integer dataRealId) {
		this.dataRealId = dataRealId;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getModAddr() {
		return modAddr;
	}

	public void setModAddr(Integer modAddr) {
		this.modAddr = modAddr;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getRw() {
		return rw;
	}

	public void setRw(Integer rw) {
		this.rw = rw;
	}

	public Integer getFre() {
		return fre;
	}

	public void setFre(Integer fre) {
		this.fre = fre;
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
		ConfigProtocol other = (ConfigProtocol) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getDataRealId() == null ? other.getDataRealId() == null : this.getDataRealId().equals(other.getDataRealId())) && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
				&& (this.getModAddr() == null ? other.getModAddr() == null : this.getModAddr().equals(other.getModAddr())) && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getRw() == null ? other.getRw() == null : this.getRw().equals(other.getRw())) && (this.getFre() == null ? other.getFre() == null : this.getFre().equals(other.getFre())) && (this.getAtTime() == null ? other.getAtTime() == null : this.getAtTime().equals(other.getAtTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getDataRealId() == null) ? 0 : getDataRealId().hashCode());
		result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
		result = prime * result + ((getModAddr() == null) ? 0 : getModAddr().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getRw() == null) ? 0 : getRw().hashCode());
		result = prime * result + ((getFre() == null) ? 0 : getFre().hashCode());
		result = prime * result + ((getAtTime() == null) ? 0 : getAtTime().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", dataRealId=").append(dataRealId);
		sb.append(", deviceId=").append(deviceId);
		sb.append(", modAddr=").append(modAddr);
		sb.append(", type=").append(type);
		sb.append(", rw=").append(rw);
		sb.append(", fre=").append(fre);
		sb.append(", atTime=").append(atTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}