package org.wws.dao;

import java.util.List;

import org.wws.pojo.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee employee);
	public List<Employee> listEmployees();
	public Employee getEmployee(Integer id);
	public void removeEmployee(Integer id);
	
	public void updateEmployee(Employee em);
}
