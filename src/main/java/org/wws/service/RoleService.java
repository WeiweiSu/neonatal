package org.wws.service;

import java.util.List;

import org.wws.pojo.Role;

public interface RoleService {

	public void addRole(Role role);
	public List<Role> listRoles();
	public Role getRole(Integer id);
	public void removeRole(Integer id);
}
