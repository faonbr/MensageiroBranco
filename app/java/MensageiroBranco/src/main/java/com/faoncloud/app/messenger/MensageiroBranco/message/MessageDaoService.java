package com.faoncloud.app.messenger.MensageiroBranco.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageDaoService {

		private static int messageCount = 4;
		private static List<Message> messages = new ArrayList<>();
		
		static {			
			messages.add(new Message(1, 2, 1, "Hello Android, this is iOS.", new Date(1582681612030L), "yes"));
			messages.add(new Message(2, 3, 1, "Hello Android, this is Tablet 1!", new Date(1582681612032L), "no"));
			messages.add(new Message(3, 4, 1, "Hello Android, this is Tablet 2!", new Date(1582681612033L), "no"));
			messages.add(new Message(4, 1, 2, "Hello iOS, this is Android!", new Date(1582681612033L), "no"));
		}
		
		
		public List<Message> findAll(){
			return messages;
		}
		
		public List<Message> findAllFromClient(int clientId, String read){
			List<Message> allFromMessages = new ArrayList<>();
			for(Message message: messages) {
				if(message.getFromid()==clientId) {
					if(read==null || read.equalsIgnoreCase(message.getRead())) allFromMessages.add(message);
				}
			}
			return allFromMessages;
		}
		
		public List<Message> findAllToClient(int clientId, String read){
			List<Message> allToMessages = new ArrayList<>();
			for(Message message: messages) {
				if(message.getToid()==clientId) {
					if(read==null || read.equalsIgnoreCase(message.getRead())) allToMessages.add(message);
				}
			}
			return allToMessages;
		}	
		
		public Message save(Message message) {
			if(message.getId()==null) {
				message.setId(++messageCount);
			}
			message.setRead("no");
			messages.add(message);
			return message;
		}
		
		public Message findOne(int id) {
			for(Message message: messages) {
				if(message.getId()==id) {
					return message;
				}
			}
			return null;
		}
}
