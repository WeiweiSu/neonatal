package org.wws.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wws.dao.EmployeeDAO;
import org.wws.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployees() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public Employee getEmployee(Integer id) {
		return (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
	}

	@Override
	public void removeEmployee(Integer id) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
        if (null != employee) {
        	try {
        		sessionFactory.getCurrentSession().delete(employee);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}

	@Override
	public void updateEmployee(Employee em) {
		sessionFactory.getCurrentSession().merge(em);
		sessionFactory.getCurrentSession().flush();
	}

}
