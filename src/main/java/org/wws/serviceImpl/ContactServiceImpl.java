package org.wws.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wws.dao.ContactDAO;
import org.wws.pojo.Contact;
import org.wws.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	
	
	@Override
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Override
	public List<Contact> listContacts() {
		return contactDAO.listContacts();
	}

	@Override
	public Contact getContact(Integer id) {
		return contactDAO.getContact(id);
	}

	@Override
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}

	@Override
	public List<Contact> getContactsByUserName(String username) {
		return contactDAO.getContactsByUserName(username);
	}

}
