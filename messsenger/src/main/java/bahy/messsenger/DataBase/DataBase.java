package bahy.messsenger.DataBase;

import java.util.HashMap;
import java.util.Map;

import bahy.messsenger.model.Message;
import bahy.messsenger.model.Profile;

public class DataBase {

	private static Map<Integer , Message> messages = new HashMap<>();
	private static Map<String , Profile> profile = new HashMap<>();
	
	
	
	
	public static  Map<Integer , Message> getmessages(){
		
		return messages;
	}

	
	public static  Map<String , Profile> getprofile(){
		
		return profile;
	}

}
