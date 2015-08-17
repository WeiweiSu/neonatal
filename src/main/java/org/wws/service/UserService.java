package org.wws.service;

import java.util.List;

import org.wws.pojo.User;

public interface UserService {

	public void addUser(User user);
	public List<User> listUsers();
	public User getUser(Integer id);
	public void removeUser(Integer id);
	public void updateUser(User user);

	public User getUser(String username, String password);
	public User getUserByUserName(String username);
	public List<User> listUsersByRole(String authority);
}
