package com.faoncloud.app.messenger.MensageiroBranco.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientResource {

	@Autowired
	private ClientDaoService service;

	@GetMapping(path="/ping")
	public String ping() {
		return "pong!";
	}

	/*
	 * List all clients with their status.
	 * TODO: Shared key can't be returned.
	 */
	@GetMapping(path="/v1/clients")
	public List<Client> retreiveAllClients() {
		return service.findAll();
	}

	/*
	 * Information of a specific client.
	 * TODO: Shared key can't be returned.
	 */
	@GetMapping(path="/v1/clients/{id}")
	public Client retreiveClient(@PathVariable int id) {
		return service.findOne(id);
	}
//
//	/*
//	 * Clients register itself as online.
//	 * TODO: Receive body content.
//	 * TODO: Need to validate the shared key as header before accepting the data.
//	 */
//	@PostMapping(path="/v1/clients/{id}")
//	public String registerClientOnline(@PathVariable int id) {
//		return String.format("Client %s has been set online.", id);
//	}
//
//	/*
//	 * Clients register itself as offline.
//	 * TODO: Receive body content.
//	 * TODO: Need to validate the shared key as header before accepting the data.
//	 */
//	@DeleteMapping(path="/v1/clients/{id}")
//	public String registerClientOffline(@PathVariable int id) {
//		return String.format("Client %s has been set offline.", id);
//	}
//
//	/*
//	 * Client updates its info
//	 * TODO: Receive body content.
//	 * TODO: Need to validate the shared key as header before accepting the data.
//	 */
//	@PutMapping(path="/v1/clients/{id}")
//	public String updateInfo(@PathVariable int id) {
//		return String.format("Client %s information updated.", id);
//	}
}
