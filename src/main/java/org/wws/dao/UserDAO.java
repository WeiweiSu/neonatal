package org.wws.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.wws.exception.AdException;
import org.wws.pojo.Message;
import org.wws.pojo.User;


public interface UserDAO {

	public void addUser(User user);
	public List<User> listUsers();
	public User getUser(Integer id);
	public void removeUser(Integer id);
	public void updateUser(User user);
	
	public User getUser(String username, String password);
	public User getUserByUserName(String username);
	public List<User> listUsersByRole(String authority);
	
	
//    public UserDAO() {
//    }
//
//    public User get(String username)
//            throws AdException {
//        try {
//            begin();
//            Query q = getSession().createQuery("from User where username = :username");
//            q.setString("username", username);
//            User user = (User) q.uniqueResult();
//            commit();
//            return user;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not get user " + username, e);
//        }
//    }
//
//    public User getById(int id)
//            throws AdException {
//        try {
//            begin();
//            User user = (User) getSession().get(User.class, id);
//            commit();
//            return user;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not get user by id " + id, e);
//        }
//    }
//    
//    public User create(String username, String password)
//            throws AdException {
//        try {
//            begin();
//            User user = new User(username, password);
//            getSession().save(user);
//            commit();
//            return user;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Exception while creating user: " + e.getMessage());
//        }
//    }
//    
//    public User update(User user)
//            throws AdException {
//        try {
//            begin();
//            getSession().update(user);
//            commit();
//            return user;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Exception while updating user: " + e.getMessage());
//        }
//    }
//
//    public void delete(User user)
//            throws AdException {
//        try {
//            begin();
//            getSession().delete(user);
//            commit();
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not delete user " + user.getUsername(), e);
//        }
//    }
}