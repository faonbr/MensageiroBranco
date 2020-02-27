package com.faoncloud.app.messenger.MensageiroBranco.beans;

//{
//	  "fromid": "1",
//	  "message": "Olá Mamae. Aqui é o papai.",
//	  "sentdate": 1582680700506,
//	  "toid": "2",
//	  "read":"no"
//	}

public class MessageBean {

	private String fromid;
	private String message;
	private String sentdate;
	private String toid;
	private String read;
	
	public MessageBean(String fromid, String message, String sentdate, String toid, String read) {
		super();
		this.fromid = fromid;
		this.message = message;
		this.sentdate = sentdate;
		this.toid = toid;
		this.read = read;
	}
	public String getFromid() {
		return fromid;
	}
	public void setFromid(String fromid) {
		this.fromid = fromid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSentdate() {
		return sentdate;
	}
	public void setSentdate(String sentdate) {
		this.sentdate = sentdate;
	}
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	@Override
	public String toString() {
		return "MessageBean [fromid=" + fromid + ", message=" + message + ", sentdate=" + sentdate + ", toid=" + toid
				+ ", read=" + read + "]";
	}
	
	
}
