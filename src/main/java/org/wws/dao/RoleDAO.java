package org.wws.dao;

import java.util.List;

import org.wws.pojo.Role;
import org.wws.pojo.User;

public interface RoleDAO {

	public void addRole(Role role);
	public List<Role> listRoles();
	public Role getRole(Integer id);
	public void removeRole(Integer id);
	
}
