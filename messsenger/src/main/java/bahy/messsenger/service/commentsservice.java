package bahy.messsenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bahy.messsenger.DataBase.DataBase;
import bahy.messsenger.model.Message;
import bahy.messsenger.model.comments;

public class commentsservice {
 
	
private Map <Integer , Message> messages = DataBase.getmessages();	


	
public commentsservice() {
	
//	 Map <Integer , comments> comment = new HashMap<>();
//	 comment.put(1, new comments(1,"hi", new Date(),"bahy"));
//	 Message m= new Message(1, "test", new Date(),"test message");
//	 
//	m.setComments(comment);
}

public List<comments> GetAllComments(int  messageid){
	 Map <Integer , comments> comments = messages.get(messageid).getComments();
	
	return new ArrayList<comments>(comments.values()); 
}
	
  public comments GetAComment(int messageid ,int commentsid){
	  Map <Integer , comments> comments = messages.get(messageid).getComments();
	  return comments.get(commentsid);

}
  
  public comments AddAComment(int messageid , comments comment){
	  Map <Integer , comments> comments = messages.get(messageid).getComments();
	  comment.setId(comments.size()+1);
	  comments.put(comment.getId(), comment);
	  return comment;

}
  
  public comments UpdateComment(int messageid ,int commentsid , comments comment){
	  Map <Integer , comments> comments = messages.get(messageid).getComments();
   
	  if(commentsid <=0)return null;
	  
	  comments.put(comment.getId(), comment);
  return comment;
}
  
  
  
  public void RemoveComment(int messageid ,int commentsid ){
	  Map <Integer , comments> comments = messages.get(messageid).getComments();
   
	 
	  
	  comments.remove( commentsid);
  
}
  
  
  
  
  
  
  
  
  
  
}
