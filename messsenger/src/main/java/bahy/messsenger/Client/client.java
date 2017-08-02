package bahy.messsenger.Client;

import java.util.Date;
import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bahy.messsenger.model.Message;







public class client {
	public Client client = ClientBuilder.newClient();
	public WebTarget target = client.target("http://localhost:8080/messsenger/webapi/");
	public WebTarget messagetarget = target.path("messages/");
	public	Message mess = new Message();

	public	Message mess1 = new Message();

	public	Message mess2 = new Message();
	public String message_string ; 
	
	
	
	public String getrequest(String link) {
	
		
	     
	    	   
//	    	Response res = client.target(link).request().get();
//	    	mess= res.readEntity(Message.class);
//			*****************************************************************************************   
//	        target=  client.target(link);
//	        Builder buk = target.request();
//	        Response res = buk.get();
//		mess	= res.readEntity(Message.class);
//	***************************************************************************************************
//	    	   mess= client.target(link).request(MediaType.APPLICATION_JSON).get(Message.class);
//	    **************************************************************************************************	   
//	  message_string  = client.target(link).request(MediaType.APPLICATION_JSON).get(String.class);	   
//	******************************************************************************************************
		
		
		WebTarget singlemessagetarget=messagetarget.path("{messageid}");
		 
		mess1 = singlemessagetarget.resolveTemplate("messageid", "1").request(MediaType.APPLICATION_JSON).get(Message.class);
	    	   

		 mess2 = singlemessagetarget.resolveTemplate("messageid", "2").request(MediaType.APPLICATION_JSON).get(Message.class);
//	      ***********************************************************************************************************************
//		 
//	    Message postmessage = new Message(3, "client",new Date(), "message client");
//	    
//	  Response postresponse =   messagetarget.request().post(Entity.json(postmessage));
//	   *****************************************************************************************************************;
	  
//	  Response deleteresponse = singlemessagetarget.resolveTemplate("messageid", "4").request(MediaType.APPLICATION_JSON).delete();
//	  *************************************************************************************************************************
		  Message putmessage = new Message(3, "putclient",new Date(), "message putclient");
		 Response putresponse = singlemessagetarget.resolveTemplate("messageid", "3").request(MediaType.APPLICATION_JSON)
				 .put(Entity.json(putmessage));
//		
		 
		 
		 
//		 return	mess.getMessage();
	       
//	       return message_string;
//		return	mess1.getMessage()+"   ______   "
//		+	mess2.getMessage();
	  
	  
//	  return postresponse.readEntity(Message.class).getMessage();
	  
//	  return postresponse.getStatus()+"";
	
//	return messagetarget.request(MediaType.APPLICATION_JSON).get(String.class);
//	  return deleteresponse.getStatus()+""+deleteresponse.getStatusInfo();
	 return putresponse.getStatus()+""+putresponse.getStatusInfo()+"\n"+messagetarget.request(MediaType.APPLICATION_JSON).get(String.class); 
	} 
	
	
	public  Invocation invocationdemo_foryear(int year) {
		
	 return 	messagetarget.queryParam("year", year).request(MediaType.APPLICATION_JSON).buildGet();
		
		
	}

	public  List<Message> ListMessage_GenericType() {
		
		 return 	messagetarget.request(MediaType.APPLICATION_JSON).
				 get(new GenericType<List<Message>>() {});
			
			
		}
	public static void main(String[] args) {

//		System.out.println(new client().getrequest(""));
		
//		********************************************************************** 
		
//		 Response invocation_response = new client().invocationdemo_foryear(2015).invoke();
//		 System.out.println(invocation_response.getStatusInfo());
		 
		
//		************************************************************
		
		System.out.println(new client().ListMessage_GenericType().toString());
		
		
	}

}
