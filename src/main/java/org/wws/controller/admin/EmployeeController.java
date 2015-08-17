package org.wws.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wws.pojo.Employee;
import org.wws.service.EmployeeService;
import org.wws.service.UserService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showform(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", employeeService.listEmployees());
		return "admin/home";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addEmployee(@Valid Employee employee, BindingResult br) {
		if(br.hasErrors()) {
			return "admin/home";
		}
		
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}
	
	
	@RequestMapping(value="/{employeeId}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteEmployee(@PathVariable Integer employeeId) {
		Employee em = employeeService.getEmployee(employeeId);
		
		String username = em.getUseraccount();
		userService.removeUser(userService.getUserByUserName(username).getId());
		
		employeeService.removeEmployee(employeeId);
		
		return "";
	}
	
}
