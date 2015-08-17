package org.wws.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="messages")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="messageID",unique=true,nullable=false)
	private int id;
	
	@Column(name="userName", nullable=false, length=50)
	private String username;
	
	@Column(name="fromUser", nullable=false, length=50)
	private String fromUser;
	
	@Column(name="message", length=100)
	@NotNull
	@NotEmpty
	private String message;
	
	@Column(name="messageDate")
	private String messageDate;
	
//	@Column(name="messageDate")
//	private Date messageDate;
	
//	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinColumn(name="fk_user",nullable=false)
//	private User user;
	
	public Message() {}

	public Message(String username, String fromUser, String message, String messageDate) {
		this.username = username;
		this.fromUser = fromUser;
		this.message = message;
		this.messageDate = messageDate;
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

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	
	

//	public Date getMessageDate() {
//		return messageDate;
//	}
//
//	public void setMessageDate(Date messageDate) {
//		this.messageDate = messageDate;
//	}
	
	
}
