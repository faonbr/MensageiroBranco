package com.faoncloud.app.messenger.MensageiroBranco.client;

import java.util.Date;

//{
//	  "ip": "1.1.1.1",
//	  "id": "1",
//	  "secret": "111",
//	  "description": "Cell Felippe",
//	  "onlinestatus":"off",
//	  "lasttimeon": "1582681612029"
//	}

public class Client {
	
	private Integer id;
	private String ip;
	private String secret;
	private String description;
	private String onlinestatus;
	private Date lasttimeon;

	public Client(Integer id, String ip, String secret, String description, String onlinestatus, Date lasttimeon) {
		super();
		this.id = id;
		this.ip = ip;
		this.secret = secret;
		this.description = description;
		this.onlinestatus = onlinestatus;
		this.lasttimeon = lasttimeon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOnlinestatus() {
		return onlinestatus;
	}

	public void setOnlinestatus(String onlinestatus) {
		this.onlinestatus = onlinestatus;
	}

	public Date getLasttimeon() {
		return lasttimeon;
	}

	public void setLasttimeon(Date lasttimeon) {
		this.lasttimeon = lasttimeon;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", ip=" + ip + ", secret=" + secret + ", description=" + description
				+ ", onlinestatus=" + onlinestatus + ", lasttimeon=" + lasttimeon + "]";
	}

	
	
}
