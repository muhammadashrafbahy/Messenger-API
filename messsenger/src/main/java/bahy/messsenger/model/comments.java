package bahy.messsenger.model;

import java.util.Date;

public class comments {

	private int id ;
	private String comment;
	private Date created;
	private String author;
	
	
	
	
	public comments() {
	
	}
	public comments(int id, String comment, Date created, String author) {
	
		this.id = id;
		this.comment = comment;
		this.created = created;
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
