package com.faoncloud.app.messenger.MensageiroBranco.message;

import java.util.Date;

//{
//	  "fromid": "1",
//	  "message": "Olá Mamae. Aqui é o papai.",
//	  "sentdate": 1582680700506,
//	  "toid": "2",
//	  "read":"no"
//	}

public class Message {

	private Integer id;
	private Integer fromid;
	private Integer toid;
	private String message;
	private Date sentdate;
	private String read;
	
	public Message(Integer id, Integer fromid, Integer toid, String message, Date sentdate, String read) {
		super();
		this.id = id;
		this.fromid = fromid;
		this.toid = toid;
		this.message = message;
		this.sentdate = sentdate;
		this.read = read;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFromid() {
		return fromid;
	}
	public void setFromid(Integer fromid) {
		this.fromid = fromid;
	}
	public Integer getToid() {
		return toid;
	}
	public void setToid(Integer toid) {
		this.toid = toid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSentdate() {
		return sentdate;
	}
	public void setSentdate(Date sentdate) {
		this.sentdate = sentdate;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", fromid=" + fromid + ", toid=" + toid + ", message=" + message + ", sentdate="
				+ sentdate + ", read=" + read + "]";
	}
	
	
}
