package com.Sia.model;

import java.io.Serializable;
import java.util.Date;

public class Menus implements Serializable {
	private Integer id;

	private String title;

	private String icon;

	private Integer isEnable;

	private Integer atIndex;

	private Date atTime;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Integer getAtIndex() {
		return atIndex;
	}

	public void setAtIndex(Integer atIndex) {
		this.atIndex = atIndex;
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
		Menus other = (Menus) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle())) && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
				&& (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable())) && (this.getAtIndex() == null ? other.getAtIndex() == null : this.getAtIndex().equals(other.getAtIndex()))
				&& (this.getAtTime() == null ? other.getAtTime() == null : this.getAtTime().equals(other.getAtTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
		result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
		result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
		result = prime * result + ((getAtIndex() == null) ? 0 : getAtIndex().hashCode());
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
		sb.append(", title=").append(title);
		sb.append(", icon=").append(icon);
		sb.append(", isEnable=").append(isEnable);
		sb.append(", atIndex=").append(atIndex);
		sb.append(", atTime=").append(atTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}