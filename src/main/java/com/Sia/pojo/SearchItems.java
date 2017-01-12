package com.Sia.pojo;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月16日
 * @description
 */
public class SearchItems {
	private String fieldLabel;
	private String emptyText;
	private String id;

	public String getSearchItems(String id, String fieldLabel, String emptyText) {
		String searchItems = "{id:'";
		searchItems += id;
		searchItems += "',fieldLabel:'";
		searchItems += fieldLabel;
		searchItems += " ',emptyText:'";
		searchItems += emptyText;
		searchItems += "',style:'text-align: right;',labelWidth:65},";
		return searchItems;
	}

	public String getFieldLabel() {
		return fieldLabel;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public String getEmptyText() {
		return emptyText;
	}

	public void setEmptyText(String emptyText) {
		this.emptyText = emptyText;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
