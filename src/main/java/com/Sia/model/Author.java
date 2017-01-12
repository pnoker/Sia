package com.Sia.model;

import java.io.Serializable;
import java.util.Date;

public class Author implements Serializable {
    private Integer id;

    private String name;

    private String menuAuthor;

    private String roleAuthor;

    private Date atTime;

    private static final long serialVersionUID = 1L;

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

    public String getMenuAuthor() {
        return menuAuthor;
    }

    public void setMenuAuthor(String menuAuthor) {
        this.menuAuthor = menuAuthor == null ? null : menuAuthor.trim();
    }

    public String getRoleAuthor() {
        return roleAuthor;
    }

    public void setRoleAuthor(String roleAuthor) {
        this.roleAuthor = roleAuthor == null ? null : roleAuthor.trim();
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
        Author other = (Author) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMenuAuthor() == null ? other.getMenuAuthor() == null : this.getMenuAuthor().equals(other.getMenuAuthor()))
            && (this.getRoleAuthor() == null ? other.getRoleAuthor() == null : this.getRoleAuthor().equals(other.getRoleAuthor()))
            && (this.getAtTime() == null ? other.getAtTime() == null : this.getAtTime().equals(other.getAtTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMenuAuthor() == null) ? 0 : getMenuAuthor().hashCode());
        result = prime * result + ((getRoleAuthor() == null) ? 0 : getRoleAuthor().hashCode());
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
        sb.append(", menuAuthor=").append(menuAuthor);
        sb.append(", roleAuthor=").append(roleAuthor);
        sb.append(", atTime=").append(atTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}