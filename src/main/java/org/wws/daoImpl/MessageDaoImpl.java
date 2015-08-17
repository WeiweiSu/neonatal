package org.wws.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wws.dao.MessageDAO;
import org.wws.pojo.Message;


@Repository
public class MessageDaoImpl implements MessageDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addMessage(Message message) {
		sessionFactory.getCurrentSession().save(message);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> listMessages() {
		return sessionFactory.getCurrentSession().createQuery("from Message").list();
	}

	@Override
	public Message getMessage(Integer id) {
		return (Message) sessionFactory.getCurrentSession().load(Message.class, id);
	}

	@Override
	public void removeMessage(Integer id) {
		Message message = (Message) sessionFactory.getCurrentSession().get(Message.class, id);
        if (null != message) {
        	try {
        		sessionFactory.getCurrentSession().delete(message);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> listMessagesByUserName(String username) {
		Query query =  sessionFactory.getCurrentSession().createQuery("from Message where username = :username");
		query.setParameter("username", username);
		return query.list();
	}


}
