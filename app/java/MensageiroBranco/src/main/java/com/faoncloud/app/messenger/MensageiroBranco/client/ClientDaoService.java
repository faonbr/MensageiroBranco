package com.faoncloud.app.messenger.MensageiroBranco.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.faoncloud.app.messenger.MensageiroBranco.message.Message;

@Component
public class ClientDaoService {

	private static int clientCount = 2;
	private static List<Client> clients = new ArrayList<>();
	static {			
		clients.add(new Client(1, "1.1.1.1", "111", "Android Device", "off", new Date(1582681612029L)));
		clients.add(new Client(2, "2.2.2.2", "222", "iOS Device", "off", new Date(1582681612029L)));
		clients.add(new Client(3, "3.3.3.3", "333", "Tablet 1", "off", new Date(1582681612029L)));
		clients.add(new Client(4, "4.4.4.4", "444", "Tablet 2", "off", new Date(1582681612029L)));
	}//static
	
	public List<Client> findAll(){
		return clients;
	}//List<Client> findAll()
	
	public Client save(Client client) {
		if(client.getId()==null) {
			client.setId(++clientCount);
		}//if
		clients.add(client);
		return client;
	}//Client save()
	
	public Client findOne(int id) {
		for(Client client: clients) {
			if(client.getId()==id) {
				return client;
			}//if
		}//for
		return null;
	}//Client findOne
	
	public Client update(Client client) {
		for(Client c: clients) {
			if(c.getId()==client.getId()) {
				if(client.getIp()!=null) c.setIp(client.getIp()); 
				if(client.getDescription()!=null) c.setDescription(client.getDescription()); 
				if(client.getOnlinestatus()!=null) c.setOnlinestatus(client.getOnlinestatus());
				if(client.getLasttimeon()!=null) c.setLasttimeon(client.getLasttimeon()); 
				return c;
			}//if
		}//for
		return null;
	}//Client update()
	
	public Client uddateOnlineStatus(int id) {
		for(Client client: clients) {
			if(client.getId()==id) {
				if(client.getOnlinestatus().equalsIgnoreCase("on")) {
					client.setOnlinestatus("off");
				}else if(client.getOnlinestatus().equalsIgnoreCase("off")) {
					client.setOnlinestatus("on");
				}//else if
				return client;
			}//if
		}//for
		return null;
	}//Client uddateOnlineStatus()
				
				
}
