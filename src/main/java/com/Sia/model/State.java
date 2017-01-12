package com.Sia.model;

import java.io.Serializable;
import java.util.Date;

public class State implements Serializable {
	private Integer nodeId;

	private Date networkUp;

	private Date healthUp;

	private Date dataUp;

	private Byte sigMag;

	private Byte rate;

	private Byte lostNum;

	private Integer lostTime;

	private Byte diaResult;

	private String description;

	private String suggeat;

	private Date atTime;

	private static final long serialVersionUID = 1L;

	public State() {
		super();
	}

	/**
	 * 初始化一个状态信息，关联到一个NodeID上
	 * 
	 * @param date
	 * @param nodeId
	 */
	public State(Date date, int nodeId) {
		this.nodeId = nodeId;
		this.networkUp = date;
		this.healthUp = date;
		this.dataUp = date;
		this.atTime = date;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public Date getNetworkUp() {
		return networkUp;
	}

	public void setNetworkUp(Date networkUp) {
		this.networkUp = networkUp;
	}

	public Date getHealthUp() {
		return healthUp;
	}

	public void setHealthUp(Date healthUp) {
		this.healthUp = healthUp;
	}

	public Date getDataUp() {
		return dataUp;
	}

	public void setDataUp(Date dataUp) {
		this.dataUp = dataUp;
	}

	public Byte getSigMag() {
		return sigMag;
	}

	public void setSigMag(Byte sigMag) {
		this.sigMag = sigMag;
	}

	public Byte getRate() {
		return rate;
	}

	public void setRate(Byte rate) {
		this.rate = rate;
	}

	public Byte getLostNum() {
		return lostNum;
	}

	public void setLostNum(Byte lostNum) {
		this.lostNum = lostNum;
	}

	public Integer getLostTime() {
		return lostTime;
	}

	public void setLostTime(Integer lostTime) {
		this.lostTime = lostTime;
	}

	public Byte getDiaResult() {
		return diaResult;
	}

	public void setDiaResult(Byte diaResult) {
		this.diaResult = diaResult;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getSuggeat() {
		return suggeat;
	}

	public void setSuggeat(String suggeat) {
		this.suggeat = suggeat == null ? null : suggeat.trim();
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
		State other = (State) that;
		return (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId())) && (this.getNetworkUp() == null ? other.getNetworkUp() == null : this.getNetworkUp().equals(other.getNetworkUp()))
				&& (this.getHealthUp() == null ? other.getHealthUp() == null : this.getHealthUp().equals(other.getHealthUp())) && (this.getDataUp() == null ? other.getDataUp() == null : this.getDataUp().equals(other.getDataUp()))
				&& (this.getSigMag() == null ? other.getSigMag() == null : this.getSigMag().equals(other.getSigMag())) && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
				&& (this.getLostNum() == null ? other.getLostNum() == null : this.getLostNum().equals(other.getLostNum())) && (this.getLostTime() == null ? other.getLostTime() == null : this.getLostTime().equals(other.getLostTime()))
				&& (this.getDiaResult() == null ? other.getDiaResult() == null : this.getDiaResult().equals(other.getDiaResult())) && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
				&& (this.getSuggeat() == null ? other.getSuggeat() == null : this.getSuggeat().equals(other.getSuggeat())) && (this.getAtTime() == null ? other.getAtTime() == null : this.getAtTime().equals(other.getAtTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
		result = prime * result + ((getNetworkUp() == null) ? 0 : getNetworkUp().hashCode());
		result = prime * result + ((getHealthUp() == null) ? 0 : getHealthUp().hashCode());
		result = prime * result + ((getDataUp() == null) ? 0 : getDataUp().hashCode());
		result = prime * result + ((getSigMag() == null) ? 0 : getSigMag().hashCode());
		result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
		result = prime * result + ((getLostNum() == null) ? 0 : getLostNum().hashCode());
		result = prime * result + ((getLostTime() == null) ? 0 : getLostTime().hashCode());
		result = prime * result + ((getDiaResult() == null) ? 0 : getDiaResult().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getSuggeat() == null) ? 0 : getSuggeat().hashCode());
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
		sb.append(", networkUp=").append(networkUp);
		sb.append(", healthUp=").append(healthUp);
		sb.append(", dataUp=").append(dataUp);
		sb.append(", sigMag=").append(sigMag);
		sb.append(", rate=").append(rate);
		sb.append(", lostNum=").append(lostNum);
		sb.append(", lostTime=").append(lostTime);
		sb.append(", diaResult=").append(diaResult);
		sb.append(", description=").append(description);
		sb.append(", suggeat=").append(suggeat);
		sb.append(", atTime=").append(atTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}