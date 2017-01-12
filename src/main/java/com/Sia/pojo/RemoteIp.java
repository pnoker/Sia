package com.Sia.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月23日
 * @description
 */
@XmlRootElement(name = "RemotIP")
@XmlType(propOrder = { "desIp", "desPort","myIp","myPort","pro"})
public class RemoteIp {
	private String desIp;
	private String desPort;
	private String myIp;
	private String myPort;
	private String pro;

	public RemoteIp() {

	}

	public RemoteIp(String desIp, String desPort, String myIp, String myPort, String pro) {
		this.desIp = desIp;
		this.desPort = desPort;
		this.myIp = myIp;
		this.myPort = myPort;
		this.pro = pro;
	}

	public String getDesIp() {
		return desIp;
	}

	@XmlAttribute(name = "DesIP")
	public void setDesIp(String desIp) {
		this.desIp = desIp;
	}

	public String getDesPort() {
		return desPort;
	}

	@XmlAttribute(name = "DesPort")
	public void setDesPort(String desPort) {
		this.desPort = desPort;
	}

	public String getMyIp() {
		return myIp;
	}

	@XmlAttribute(name = "MyIP")
	public void setMyIp(String myIp) {
		this.myIp = myIp;
	}

	public String getMyPort() {
		return myPort;
	}

	@XmlAttribute(name = "MyPort")
	public void setMyPort(String myPort) {
		this.myPort = myPort;
	}

	public String getPro() {
		return pro;
	}

	@XmlAttribute(name = "Pro")
	public void setPro(String pro) {
		this.pro = pro;
	}
}
