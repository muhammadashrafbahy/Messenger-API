package bahy.messsenger.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import bahy.messsenger.model.Message;
import bahy.messsenger.service.MessageService;

@Path(value = "/messages")
@Produces ({MediaType.APPLICATION_JSON ,MediaType.TEXT_XML})
@Consumes (MediaType.APPLICATION_JSON)
public class messageresource {


	
	@GET
	@Path("/{messageId}")
public Message GetAmessage(@PathParam("messageId") int messageId ,@Context UriInfo urf) {
		Message mess = new MessageService().getmessage(messageId);
		mess.addlinks(build_URI(urf, mess, "self"), "self");
		mess.addlinks(build_URI(urf, mess, "comments"), "comments");
		mess.addlinks(build_URI(urf, mess, "profile"), "profile");
		return mess;
	

	}
	
	public String build_URI (UriInfo urf, Message mess , String rel) {
		if(rel.equals("self")) {
		return urf.getBaseUriBuilder().path(messageresource.class).
				path(String.valueOf(mess.getId())).build().toString();
		}
		
		if(rel.equals("comments")) {
			return urf.getBaseUriBuilder().path(messageresource.class)
					.path(messageresource.class, "getcomments")
					.path(commentsresource.class)
					.resolveTemplate("messageid", String.valueOf(mess.getId()))
					.build().toString();
              		
		}
		if(rel.equals("profile")) {
			return urf.getBaseUriBuilder().path(ProfileResource.class).
					path(mess.getAuthor()).build().toString();
			}
			 return null;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getjsonspecificmessage(@QueryParam ("year") int year,
			@QueryParam ("start") int start,@QueryParam ("size") int size      ) {
		if(year >0) {return new MessageService().getmessageforyear(year);}
		
		if(start >=0 && size >0) {return new MessageService().getmessageforsize(start, size);}
		
		return new MessageService().GetAllMessage();                                                            
	}

	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getxmlspecificmessage(@QueryParam ("year") int year,
			@QueryParam ("start") int start,@QueryParam ("size") int size      ) {
		if(year >0) {return new MessageService().getmessageforyear(year);}
		
		if(start >=0 && size >0) {return new MessageService().getmessageforsize(start, size);}
		
		return new MessageService().GetAllMessage();                                                            
	}
//in case of uing @beanparm***********************
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Message> getspecificmessage( @BeanParam messagefilterbean mfb     ) {
//		if(mfb.getStart() >0) {return new MessageService().getmessageforyear(mfb.getYear());}
//		
//		if(mfb.getStart() >=0 && mfb.getSize() >0) {
//			return new MessageService().getmessageforsize(mfb.getStart(), mfb.getSize());}
//		
//		return new MessageService().GetAllMessage();
//	}
//	 **********************************************                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	@POST
	
	
	public Response addmessage(Message message , @Context UriInfo urf) throws URISyntaxException {
		
		
	Message m =	 new MessageService().addmessage(message);
	String id =String.valueOf(m.getId());
				URI u = urf.getAbsolutePathBuilder().path(id).build();
		return Response.created(u).entity(m).build();
	}
	
	
	@PUT
	@Path("/{messageId}")
	public Message updatemessage(Message message , @PathParam("messageId") int id) {
		message.setId(id);
		return new MessageService().updatemessage(message);
		
	}
	
	
	@DELETE
	@Path("/{messageId}")
	public void Deletemessage(@PathParam("messageId") int id) {
		
		new MessageService().removemessage(id);
		
	}
	
	
	
	@Path ("/{messageid}/comments")
	public commentsresource getcomments() {
		
		return new commentsresource();
	}
	
	
	
	
}
