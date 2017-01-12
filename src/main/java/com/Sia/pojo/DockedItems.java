package com.Sia.pojo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月15日
 * @description
 */

public class DockedItems {
	private String xtype;
	private String text;
	private String icon;
	private String handler;

	public String getDockedItems(HttpServletRequest request, String text, String icon, String handler) {
		String dockedItems = "{xtype : 'button',icon : '";
		dockedItems += request.getContextPath();
		dockedItems += "/images/icon/";
		dockedItems += icon;
		dockedItems += ".png',";
		dockedItems += "text:'";
		dockedItems += text;
		dockedItems += "',handler:";
		dockedItems += handler;
		dockedItems += "},";
		return dockedItems;
	}

	public String getXtype() {
		return xtype;
	}

	public void setXtype(String xtype) {
		this.xtype = xtype;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}
}
