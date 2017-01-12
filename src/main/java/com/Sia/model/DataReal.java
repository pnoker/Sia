package com.Sia.model;

import java.io.Serializable;
import java.util.Date;

public class DataReal implements Serializable {
	private Integer nodeId;

	private Integer adapterId;

	private String name;

	private String valueType;

	private String writeAble;

	private Byte tag;

	private String value;

	private Integer protocolId;

	private Date atTime;

	private static final long serialVersionUID = 1L;

	public DataReal() {
		super();
	}

	public DataReal(int nodeId, int adapterId, String name, String valueType, String writeAble, int tag, int protocolId) {
		this.nodeId = nodeId;
		this.adapterId = adapterId;
		this.name = name;
		this.valueType = valueType;
		this.writeAble = writeAble;
		this.tag = (byte) tag;
		this.protocolId = protocolId;
		this.atTime = new Date();
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public Integer getAdapterId() {
		return adapterId;
	}

	public void setAdapterId(Integer adapterId) {
		this.adapterId = adapterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType == null ? null : valueType.trim();
	}

	public String getWriteAble() {
		return writeAble;
	}

	public void setWriteAble(String writeAble) {
		this.writeAble = writeAble == null ? null : writeAble.trim();
	}

	public Byte getTag() {
		return tag;
	}

	public void setTag(Byte tag) {
		this.tag = tag;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	public Integer getProtocolId() {
		return protocolId;
	}

	public void setProtocolId(Integer protocolId) {
		this.protocolId = protocolId;
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
		DataReal other = (DataReal) that;
		return (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId())) && (this.getAdapterId() == null ? other.getAdapterId() == null : this.getAdapterId().equals(other.getAdapterId()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName())) && (this.getValueType() == null ? other.getValueType() == null : this.getValueType().equals(other.getValueType()))
				&& (this.getWriteAble() == null ? other.getWriteAble() == null : this.getWriteAble().equals(other.getWriteAble())) && (this.getTag() == null ? other.getTag() == null : this.getTag().equals(other.getTag()))
				&& (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue())) && (this.getProtocolId() == null ? other.getProtocolId() == null : this.getProtocolId().equals(other.getProtocolId()))
				&& (this.getAtTime() == null ? other.getAtTime() == null : this.getAtTime().equals(other.getAtTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
		result = prime * result + ((getAdapterId() == null) ? 0 : getAdapterId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getValueType() == null) ? 0 : getValueType().hashCode());
		result = prime * result + ((getWriteAble() == null) ? 0 : getWriteAble().hashCode());
		result = prime * result + ((getTag() == null) ? 0 : getTag().hashCode());
		result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
		result = prime * result + ((getProtocolId() == null) ? 0 : getProtocolId().hashCode());
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
		sb.append(", adapterId=").append(adapterId);
		sb.append(", name=").append(name);
		sb.append(", valueType=").append(valueType);
		sb.append(", writeAble=").append(writeAble);
		sb.append(", tag=").append(tag);
		sb.append(", value=").append(value);
		sb.append(", protocolId=").append(protocolId);
		sb.append(", atTime=").append(atTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}