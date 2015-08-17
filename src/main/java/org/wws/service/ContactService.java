package org.wws.service;

import java.util.List;

import org.wws.pojo.Contact;

public interface ContactService {

	public void addContact(Contact contact);
	public List<Contact> listContacts();
	public Contact getContact(Integer id);
	public void removeContact(Integer id);
	
	public List<Contact> getContactsByUserName(String username);
	
}
