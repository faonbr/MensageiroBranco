package com.faoncloud.app.messenger.MensageiroBranco.message;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.faoncloud.app.messenger.MensageiroBranco.message.MessageDaoService;

@RestController
public class MessageResource {

	@Autowired
	private MessageDaoService service;
	
	@GetMapping(path="/messages")
	public List<Message> retreiveAllMessages() {
		return service.findAll();
	}
	
	/*
	 * List all messages of the specified client.
	 * TODO: Receive body content.
	 * TODO: Need to validate the shared key as header before accepting the data. 
	 */
	@GetMapping(path="/clients/{clientId}/messages")
	public List<Message> retreiveAllMessages(@PathVariable int clientId) {
		return service.findAllToClient(clientId, null);
	}
	
	/*
	 * List all unread messages of the specified client.
	 * TODO: Need to validate the shared key as header before accepting the data. 
	 */
	@GetMapping(path="/clients/{clientId}/messages/unread")
	public List<Message>  retreiveUnreadMessages(@PathVariable int clientId) {
		return service.findAllToClient(clientId, "no");
	}
	
	/*
	 * List all read messages of the specified client.
	 * TODO: Need to validate the shared key as header before accepting the data. 
	 */
	@GetMapping(path="/clients/{clientId}/messages/read")
	public List<Message> retreiveReadMessages(@PathVariable int clientId) {
		return service.findAllToClient(clientId, "yes");
	}
	
	/*
	 * Post message from the specified client.
	 */
	@PostMapping(path="/clients/{clientId}/messages")
	public Message postMessage(@RequestBody Message message) {
		return service.save(message);
	}
	
//	/*
//	 * Update read status of the specified message of the specified client.
//	 * TODO: Need to validate the shared key as header before accepting the data. 
//	 */
//	@PutMapping(path="/clients/{clientId}/messages/{messageId}")
//	public String updateMessageToReadStatus(@PathVariable String clientId, @PathVariable String messageId) {
//		return String.format("Message %s of client %s has been set read.", messageId, clientId);
//	}
//	

}
