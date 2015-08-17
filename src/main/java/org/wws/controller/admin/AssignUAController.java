package org.wws.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wws.pojo.Employee;
import org.wws.pojo.Role;
import org.wws.pojo.User;
import org.wws.service.EmployeeService;
import org.wws.service.RoleService;
import org.wws.service.UserService;

@Controller
@RequestMapping("/assignUserAccount")
public class AssignUAController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping(value="/{employeeID}",method=RequestMethod.GET)
	public String showHome(@PathVariable Integer employeeID, Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("employeeID", employeeID);
		return "admin/assignua";
	}
	
	@RequestMapping(value="/{employeeID}", method=RequestMethod.POST)
	public String assignUA(@Valid User user, BindingResult br, @PathVariable Integer employeeID, Model model) {
		if(br.hasErrors()) {
			return "admin/assignua";
		}
		
		User existUser = userService.getUserByUserName(user.getUsername());
		if(existUser != null) {
			model.addAttribute("error", "Duplicate User Name, please try another one");
			return "admin/assignua";
		}
		
		
		
		
		
		Employee em = employeeService.getEmployee(employeeID);
		String useraccount = user.getUsername();
		em.setUseraccount(useraccount);
		
		//encode password
		String encoded = encoder.encode(user.getPassword());
		user.setPassword(encoded);
		
		user.setEnabled(true);
		
		Role role = new Role();
		role.setAuthority("ROLE_MODERATOR");
		role.setUser(user);
		user.getRoles().add(role);
		
		userService.addUser(user);
		employeeService.updateEmployee(em);
		roleService.addRole(role);
		
		return "redirect:/employees";
		
	}
}
