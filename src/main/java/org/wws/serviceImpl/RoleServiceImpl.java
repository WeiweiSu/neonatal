package org.wws.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wws.dao.RoleDAO;
import org.wws.pojo.Role;
import org.wws.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public void addRole(Role role) {
		roleDAO.addRole(role);
	}

	@Override
	public List<Role> listRoles() {
		return roleDAO.listRoles();
	}

	@Override
	public Role getRole(Integer id) {
		return roleDAO.getRole(id);
	}

	@Override
	public void removeRole(Integer id) {
		roleDAO.removeRole(id);
	}

}
