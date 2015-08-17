package org.wws.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wws.dao.RoleDAO;
import org.wws.pojo.Role;

@Repository
public class RoleDaoImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listRoles() {
		return sessionFactory.getCurrentSession().createQuery("From Role").list();
	}

	@Override
	public Role getRole(Integer id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}

	@Override
	public void removeRole(Integer id) {
		Role role = (Role) sessionFactory.getCurrentSession().get(Role.class, id);
        if (null != role) {
        	try {
        		sessionFactory.getCurrentSession().delete(role);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}

}
