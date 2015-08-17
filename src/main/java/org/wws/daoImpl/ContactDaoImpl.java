package org.wws.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wws.dao.ContactDAO;
import org.wws.pojo.Contact;

@Repository
public class ContactDaoImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> listContacts() {
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	@Override
	public Contact getContact(Integer id) {
		return (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
	}

	@Override
	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
        if (null != contact) {
        	try {
        		sessionFactory.getCurrentSession().delete(contact);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getContactsByUserName(String username) {
		Query q = sessionFactory.getCurrentSession().createQuery("From Contact Where username = :username");
		q.setParameter("username", username);
		return q.list();
	}

}
