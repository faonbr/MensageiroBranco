package com.faoncloud.app.messenger.MensageiroBranco.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faoncloud.app.messenger.MensageiroBranco.beans.MessageBean;

@RestController
public class MessageController {

	/*
	 * List all messages to the specified client.
	 * TODO: Receive body content.
	 * TODO: Need to validate the shared key as header before accepting the data. 
	 */
	@GetMapping(path="/clients/{clientId}/messages")
	public List<MessageBean> listAllMessagesOfClient(@PathVariable String clientId) {
		return Arrays.asList(new MessageBean("2", "1", "Olá papai. Aqui é a mamae.", "1582681612030", "yes"),
							 new MessageBean("3", "1", "Oi Papai, é a Carol!", "1582681612032", "no"),
							 new MessageBean("4", "1", "Oi Papai, é a Larissa!", "1582681612032", "no"));
	}
	
	/*
	 * List all clients with their status.
	 * TODO: Need to validate the shared key as header before accepting the data. 
	 */
	@GetMapping(path="/clients/{clientId}/messages/unread")
	public List<MessageBean> listUnreadMessagesOfClient(@PathVariable String clientId) {
		return Arrays.asList(new MessageBean("3", "1", "Oi Papai, é a Carol!", "1582681612032", "no"),
				 			 new MessageBean("4", "1", "Oi Papai, é a Larissa!", "1582681612032", "no"));
	}
	
	/*
	 * List all clients with their status.
	 * TODO: Need to validate the shared key as header before accepting the data. 
	 */
	@GetMapping(path="/clients/{clientId}/messages/read")
	public List<MessageBean> listReadMessagesOfClient(@PathVariable String clientId) {
		return Arrays.asList(new MessageBean("2", "1", "Olá papai. Aqui é a mamae.", "1582681612030", "yes"));
	}
	
	/*
	 * List all clients with their status.
	 * TODO: Need to validate the shared key as header before accepting the data. 
	 */
	@PutMapping(path="/clients/{clientId}/messages/{messageId}")
	public String updateMessageToReadStatus(@PathVariable String clientId, @PathVariable String messageId) {
		return String.format("Message %s of client %s has been set read.", messageId, clientId);
	}
	
}
