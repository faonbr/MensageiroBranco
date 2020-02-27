package com.faoncloud.app.messenger.MensageiroBranco.beans;

//{
//	  "ip": "1.1.1.1",
//	  "id": "1",
//	  "secret": "111",
//	  "description": "Cell Felippe",
//	  "onlinestatus":"off",
//	  "lasttimeon": "1582681612029"
//	}

public class ClientBean {
	
	private String id;
	private String ip;
	private String secret;
	private String description;
	private String onlinestatus;
	private String lasttimeon;

	public ClientBean(String id, String ip, String secret, String description, String onlinestatus, String lasttimeon) {
		super();
		this.id = id;
		this.ip = ip;
		this.secret = secret;
		this.description = description;
		this.onlinestatus = onlinestatus;
		this.lasttimeon = lasttimeon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getLasttimeon() {
		return lasttimeon;
	}

	public void setLasttimeon(String lasttimeon) {
		this.lasttimeon = lasttimeon;
	}

	@Override
	public String toString() {
		return "ClientBean [id=" + id + ", ip=" + ip + ", secret=" + secret + ", description=" + description
				+ ", onlinestatus=" + onlinestatus + ", lasttimeon=" + lasttimeon + "]";
	}
	
	
	
}
