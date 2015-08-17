package org.wws.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.wws.exception.AdException;
import org.wws.pojo.Contact;
import org.wws.pojo.Message;


public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContacts();
	public Contact getContact(Integer id);
	public void removeContact(Integer id);
	
	public List<Contact> getContactsByUserName(String username);
	
	
	

//    public List<Contact> getContactList(String username) throws AdException {
//        try {
//            begin();
//            Query q = getSession().createQuery("from Contact where username = :username");
//            q.setString("username", username);
//            List<Contact> contacts = q.list();
//            commit();
//            return contacts;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not obtain the contact with username " + username + " " + e.getMessage());
//        }
//    }
//
//    public List list() throws AdException {
//        try {
//            begin();
//            Query q = getSession().createQuery("from Contact");
//            List list = q.list();
//            commit();
//            return list;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not list the contact", e);
//        }
//    }
//
//    public Contact create(String username, String contactname, String comments, String dateAdded) throws AdException {
//        try {
//            begin();
//            Contact contact = new Contact(username, contactname, comments, dateAdded);
//            getSession().save(contact);
//            commit();
//            return contact;
//        } catch (HibernateException e) {
//            rollback();
//            //throw new AdException("Could not create the contact", e);
//            throw new AdException("Exception while creating contact: " + e.getMessage());
//        }
//    }
//
//    public void save(Contact contact) throws AdException {
//        try {
//            begin();
//            getSession().update(contact);
//            commit();
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not save the contact", e);
//        }
//    }
//
//    public void delete(Contact contact) throws AdException {
//        try {
//            begin();
//            getSession().delete(contact);
//            commit();
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not delete the category", e);
//        }
//    }
//    
//    public Contact getById(int id) throws AdException {
//        try {
//            begin();
//            Contact contact = (Contact) getSession().get(Contact.class, id);
//            commit();
//            return contact;
//        } catch (HibernateException e) {
//            rollback();
//            //throw new AdException("Could not create the contact", e);
//            throw new AdException("Exception while getting contact by id: " + e.getMessage());
//        }
//    }
//    
//    public void deleteById(int id) throws AdException {
//    	delete(getById(id));
//    }
}