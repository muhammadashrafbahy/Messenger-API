package bahy.messsenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
public class Message {
	
	private int id ;
	private String author;
	private Date created;
	private String message;
	private Map<Integer , comments> comments = new HashMap<>();
	private List<Links> List_link = new ArrayList<>();
	
		public Message() {
	}
		
		
	public Message(int id, String author, Date created, String message) {
	
		this.id = id;
		this.author = author;
		this.created = created;
		this.message = message;
	}

	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
     
    @XmlTransient
	public Map<Integer, comments> getComments() {
		return comments;
	}


	public void setComments(Map<Integer, comments> comments) {
		this.comments = comments;
	}


	public List<Links> getList_link() {
		return List_link;
	}


	public void setList_link(List<Links> list_link) {
		List_link = list_link;
	}



	
	public void addlinks (String link , String rel ) {
		Links l = new Links();
		l.setLinks(link);
		l.setRel(rel);
		List_link.add(l);
		
		
	}

}
