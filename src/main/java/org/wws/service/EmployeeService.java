package org.wws.service;

import java.util.List;

import org.wws.pojo.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	public List<Employee> listEmployees();
	public Employee getEmployee(Integer id);
	public void removeEmployee(Integer id);
	
	public void updateEmployee(Employee em);
}
