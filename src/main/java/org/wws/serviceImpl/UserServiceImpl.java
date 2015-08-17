package org.wws.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wws.dao.UserDAO;
import org.wws.pojo.User;
import org.wws.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	@Override
	public void addUser(User user) {
		userDAO.addUser(user);

	}

	@Transactional
	@Override
	public List<User> listUsers() {
		return userDAO.listUsers();
	}

	@Transactional
	@Override
	public User getUser(Integer id) {
		return userDAO.getUser(id);
	}

	@Transactional
	@Override
	public void removeUser(Integer id) {
		userDAO.removeUser(id);
	}

	@Transactional
	@Override
	public User getUser(String username, String password) {
		return userDAO.getUser(username, password);
	}

	@Override
	public User getUserByUserName(String username) {
		return userDAO.getUserByUserName(username);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public List<User> listUsersByRole(String authority) {
		return userDAO.listUsersByRole(authority);
	}
}
