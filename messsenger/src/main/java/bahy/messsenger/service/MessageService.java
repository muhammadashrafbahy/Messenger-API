package bahy.messsenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import bahy.messsenger.DataBase.DataBase;
import bahy.messsenger.Exception.DataNotFoundException;
import bahy.messsenger.model.Message;

public class MessageService {
	
	public Map <Integer ,Message> messages = DataBase.getmessages();
	
	public MessageService() {
	 messages.put(1, new Message(1,"bahy",new Date(),"hello Bahy"));	
	 messages.put(2, new Message(2,"ali",new Date(),"hello Ali"));	

	}

	
	
	
	public List<Message> GetAllMessage(){
	
		return new ArrayList<>(messages.values());
		
	}
	public Message getmessage(int id) {
		Message mess = messages.get(id);
		if(mess==null) {throw new DataNotFoundException("message with id "+id +"not found");}
	  
	  return mess;
	}
	
	
	public List<Message> getmessageforyear(int year){
		List<Message> messageforyear = new ArrayList<>();
		Calendar ca = Calendar.getInstance();
		for (Message message :messages.values()) {
			ca.setTime(message.getCreated());
			if(ca.get(Calendar.YEAR)==year) {
				
				messageforyear.add(message);
			}
		}
		return messageforyear;
	}
	
	
	public List<Message> getmessageforsize(int start , int size){
		List<Message> messageforsize = new ArrayList<>(messages.values());
		return messageforsize.subList(start, start+size);
		
	}
	
	public Message addmessage(Message message ) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message updatemessage( Message message) {
		if(message.getId()<=0)return null;
		
		messages.put(message.getId() ,message);
		
		return message;
	}

   public Message removemessage(int id) {
	   
	   return messages.remove(id);
	   
	 
	   
	   
   }

}
