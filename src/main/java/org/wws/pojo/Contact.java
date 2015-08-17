package org.wws.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contactID",unique=true,nullable=false)
	private int id;
	
	@Column(name="userName", nullable=false, length=50)
	private String username;
	
	@Column(name="contactName",length=50)
	private String contactname;
	
	@Column(name="comments", length=100)
	private String comments;
	
	@Column(name="dateAdded")
	private String dateAdded;
	
//	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinColumn(name="fk_user",nullable=false)
//	private User user;
	
	public Contact() {}
	
	public Contact(String username, String contactname, String comments, String dateAdded) {
		this.username = username;
		this.contactname = contactname;
		this.comments = comments;
		this.dateAdded = dateAdded;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
//	public User getUser() {
//		return user;
//	}
//
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	
	
}
