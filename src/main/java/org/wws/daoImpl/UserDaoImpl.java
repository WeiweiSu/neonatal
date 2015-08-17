package org.wws.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wws.dao.UserDAO;
import org.wws.pojo.User;

@Repository
public class UserDaoImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getUser(Integer id) {
		return (User) sessionFactory.getCurrentSession().load(User.class, id);
	}

	@Override
	public void removeUser(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        if (null != user) {
        	try {
        		sessionFactory.getCurrentSession().delete(user);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }

	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public User getUser(String username, String password) {
		Query query = sessionFactory.getCurrentSession().createQuery("From User Where username = :username And password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List users = query.list();
		if(users.size() != 0) return (User)users.get(0);
		return null;
	}

	@Override
	public User getUserByUserName(String username) {
		Query q = sessionFactory.getCurrentSession().createQuery("From User Where username = :username");
		q.setParameter("username", username);
		List users = q.list();
		User user = null;
		if(users.size() != 0) user =(User) users.get(0);
		return user;
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().merge(user);
		sessionFactory.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsersByRole(String authority) {
		Query query = sessionFactory.getCurrentSession().createQuery("From User as u left join u.roles r Where r.authority = :authority");
		query.setParameter("authority", authority);
		List<Object[]> moderators = query.list();
		List<User> moderatorList = new ArrayList();
		for(Object[] o : moderators) {
			moderatorList.add((User) o[0]);
		}
		
		return moderatorList;
	}

}
