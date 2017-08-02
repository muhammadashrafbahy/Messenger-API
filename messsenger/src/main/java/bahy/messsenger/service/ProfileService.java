package bahy.messsenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import bahy.messsenger.*;
import bahy.messsenger.DataBase.DataBase;
import bahy.messsenger.model.Profile;

public class ProfileService {

	
	public Map<String , Profile > profiles = DataBase.getprofile();

	public ProfileService() {
       
   profiles.put("bahy", new Profile(1, "bahy", "bahy", "bahy"));
   profiles.put("ali", new Profile(2, "ali", "bahy", "bahy"));
   
	}
	
	
	public Profile addprofile(Profile profile) {
		
	  profile.setId(profiles.size()+1);	
	  profiles.put(profile.getProfilename(),profile);
		return profile;
		
	}
	
	public List<Profile> getallprofiles(){
		
		return new ArrayList<>(profiles.values());
		
		
	}
	
	public Profile getaprofile(String profilename) {
		
		
		return profiles.get(profilename);
		
	}
	
     public Profile updateprofile (Profile profile) {
    	 
    	 profiles.put(profile.getProfilename(),profile);
    	 return profile;
    	 
     } 
     
     
     
      
    
    public void removeprofile(String profilename) {
    	
    	profiles.remove(profilename);
    	
    }
}
