package org.wws.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.wws.exception.AdException;
import org.wws.pojo.Message;


public interface MessageDAO {
	
	public void addMessage(Message message);
	public List<Message> listMessages();
	public Message getMessage(Integer id);
	public void removeMessage(Integer id);
	
	public List<Message> listMessagesByUserName(String username);
	
	
	
	
	
	
	
	
	

//	public List<Message> getMessageList(String username) throws AdException {
//        try {
//            begin();
//            Query q = getSession().createQuery("from Message where username = :username");
//            q.setString("username", username);
//            List<Message> messages = q.list();
//            commit();
//            return messages;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not obtain the message list with username " + username + " " + e.getMessage());
//        }
//    }
//
//    public List list() throws AdException {
//        try {
//            begin();
//            Query q = getSession().createQuery("from Message");
//            List list = q.list();
//            commit();
//            return list;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not list the message", e);
//        }
//    }
//
//    public Message create(String username, String fromUser, String content, String messageDate) throws AdException {
//        try {
//            begin();
//            Message message = new Message(username, fromUser, content, messageDate);
//            getSession().save(message);
//            commit();
//            return message;
//        } catch (HibernateException e) {
//            rollback();
//            //throw new AdException("Could not create the contact", e);
//            throw new AdException("Exception while creating message: " + e.getMessage());
//        }
//    }
//
//    public void save(Message message) throws AdException {
//        try {
//            begin();
//            getSession().save(message);
//            commit();
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not save the message", e);
//        }
//    }
//
//    public void delete(Message message) throws AdException {
//        try {
//            begin();
//            getSession().delete(message);
//            commit();
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not delete the message", e);
//        }
//    }
//    
//    public Message getByID(int id) throws AdException {
//        try {
//        	Message m = null;
//            begin();
//            m = (Message) getSession().get(Message.class, id);
//            commit();
//            return m;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not save the message", e);
//        }
//    }
    
}
