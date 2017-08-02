package bahy.messsenger.resource;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import bahy.messsenger.model.Profile;
import bahy.messsenger.service.ProfileService;

@Path (value="/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	@GET
	public List<Profile> GetAllProfiles(){
		
		return new ProfileService().getallprofiles();
		
	}
	@GET
	@Path("/{ProfileName}")
	public Profile GetAnProfile(@PathParam("ProfileName") String profilename) {
		
		return new ProfileService().getaprofile(profilename);
		
	}
	
	
	 @POST
	 public Profile AddAnProfile(Profile profile) {
		 
		 return new ProfileService().addprofile(profile);
		 
	 }

     @PUT 
 	 @Path("/{ProfileName}")
 	 public Profile UpdateAnProfile(@PathParam("ProfileName") String profilename , Profile profile ) {
       profile.setProfilename(profilename);
    	 
    	 return new ProfileService().updateprofile(profile);
      
     
     
       }
     

     @DELETE
 	@Path("/{ProfileName}")
 	public void DeleteAnProfile(@PathParam("ProfileName") String profilename) {
  
    new ProfileService().removeprofile(profilename);
     
  
     }
     
}
