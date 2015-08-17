package org.wws.controller.admin;

import java.util.List;

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
import org.wws.pojo.User;
import org.wws.service.EmployeeService;
import org.wws.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showform(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("userList", userService.listUsers());
		return "admin/users";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult br) {
		if(br.hasErrors()) {
			return "admin/users";
		}
		
		userService.addUser(user);
		return "redirect:/users";
		
	}
	
	@RequestMapping(value="/{userID}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteBook(@PathVariable Integer userID) {
		User user = userService.getUser(userID);
		List<Employee> employees = employeeService.listEmployees();
		for(Employee em : employees) {
			if(user.getUsername().equals(em.getUseraccount())) {
				em.setUseraccount(null);
			}
		}
		
		
		
		userService.removeUser(userID);
		
		return "redirect:/users";
	}
	
}
