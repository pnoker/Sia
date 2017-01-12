package com.Sia.pojo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Pnoker
 * @mail peter-no@fotion
 */
@XmlRootElement(name = "Config")
@XmlType(propOrder = { "remoteIp", "item" })
public class Config {
	private ArrayList<Item> item;
	private RemoteIp remoteIp;

	public Config(RemoteIp remoteIp) {
		this.remoteIp = remoteIp;
		this.item = new ArrayList<Item>();
	}

	public Config() {
		this.remoteIp = remoteIp;
		this.item = new ArrayList<Item>();
	}

	public RemoteIp getRemoteIp() {
		return remoteIp;
	}

	@XmlElement(name = "RemoteIP")
	public void setRemoteIp(RemoteIp remoteIp) {
		this.remoteIp = remoteIp;
	}

	public ArrayList<Item> getItem() {
		return item;
	}

	@XmlElement(name = "Item")
	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

}
