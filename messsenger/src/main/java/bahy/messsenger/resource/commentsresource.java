package bahy.messsenger.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import bahy.messsenger.model.comments;
import bahy.messsenger.service.commentsservice;

@Path ("/")
public class commentsresource {
   
	
	 commentsservice cmms = new commentsservice();
	
	@GET
	public List<comments> GetAllComments(@PathParam ("messageid") int messageid){
		
		return cmms.GetAllComments(messageid);
		
	}
	 
	@GET
	@Path("/{commentid}")
	public comments GetAComments(@PathParam ("messageid") int messageid ,
			          @PathParam ("commentid") int commentid){
		
		return cmms.GetAComment(messageid, commentid);
		
	}
	
	
	
	@POST
	public comments AddAComments(@PathParam ("messageid") int messageid ,
			           comments comment){
		
		return cmms.AddAComment(messageid, comment);
		
	}
	
	@PUT
	@Path("/{commentid}")
	public comments UpdateAComments(@PathParam ("messageid") int messageid ,
			          @PathParam ("commentid") int commentid , comments comment){
		
		comment.setId(commentid);
		return cmms.UpdateComment(messageid, comment.getId(), comment);
		
	}
	
	@PUT
	@Path("/{commentid}")
	public void RemoveAComments(@PathParam ("messageid") int messageid ,
			          @PathParam ("commentid") int commentid){
		
		 cmms.RemoveComment(messageid, commentid);
		
	}
}
