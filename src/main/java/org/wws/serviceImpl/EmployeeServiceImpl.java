package org.wws.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wws.dao.EmployeeDAO;
import org.wws.pojo.Employee;
import org.wws.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		return employeeDAO.listEmployees();
	}

	@Override
	public Employee getEmployee(Integer id) {
		return employeeDAO.getEmployee(id);
	}

	@Override
	public void removeEmployee(Integer id) {
		employeeDAO.removeEmployee(id);
	}

	@Override
	public void updateEmployee(Employee em) {
		employeeDAO.updateEmployee(em);
	}

}
