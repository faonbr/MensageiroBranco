package com.faoncloud.app.messenger.MensageiroBranco.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faoncloud.app.messenger.MensageiroBranco.beans.ClientBean;

@RestController
public class ClientController {
	
	@GetMapping(path="/ping")
	public String ping() {
		return "pong!";
	}
	
	/*
	 * List all clients with their status.
	 * TODO: Shared key can't be returned.
	 */
	@GetMapping(path="/clients")	
	public List<ClientBean> listAllClients() {
		return Arrays.asList(new ClientBean("1", "1.1.1.1", "111", "Celular Felippe", "off", "1582681612029"), 
							 new ClientBean("2", "2.2.2.2", "222", "Celular Cyntia", "off", "1582681612029"));
	}
	
	/*
	 * Information of a specific client.
	 * TODO: Shared key can't be returned.
	 */
	@GetMapping(path="/clients/{appid}")	
	public ClientBean clientInfo(@PathVariable String appid) {
		return new ClientBean("1", "1.1.1.1", "111", "Celular Felippe", "off", "1582681612029");
	}
	
	/*
	 * Clients register itself as online.
	 * TODO: Receive body content.
	 * TODO: Need to validate the shared key as header before accepting the data. 
	 */
	@PostMapping(path="/clients/{appid}")
	public String registerClientOnline(@PathVariable String appid) {
		return String.format("Client %s has been set online.", appid);
	}
	
	/*
	 * Clients register itself as offline.
	 * TODO: Receive body content.
	 * TODO: Need to validate the shared key as header before accepting the data. 
	 */
	@DeleteMapping(path="/clients/{appid}")
	public String registerClientOffline(@PathVariable String appid) {
		return String.format("Client %s has been set offline.", appid);
	}

	/*
	 * Client updates its info
	 * TODO: Receive body content.
	 * TODO: Need to validate the shared key as header before accepting the data. 
	 */
	@PutMapping(path="/clients/{appid}")
	public String updateInfo(@PathVariable String appid) {
		return String.format("Client %s information updated.", appid);
	}
}
