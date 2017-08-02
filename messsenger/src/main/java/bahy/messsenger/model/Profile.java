package bahy.messsenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
private int id;
private String profilename;
private String lastname;
private String firstname;
public Profile(int id, String profilename, String lastname, String firstname) {

	this.id = id;
	this.profilename = profilename;
	this.lastname = lastname;
	this.firstname = firstname;
}
public Profile() {

}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProfilename() {
	return profilename;
}
public void setProfilename(String profilename) {
	this.profilename = profilename;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}



}
