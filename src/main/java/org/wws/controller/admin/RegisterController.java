package org.wws.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wws.pojo.Role;
import org.wws.pojo.User;
import org.wws.service.RoleService;
import org.wws.service.UserService;

@Controller 
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired 
	private RoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping(method=RequestMethod.GET)
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		
		return "register/register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String process(@Valid User user, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "register/register";
		}
		
		//check if username is existed
		User existUser = userService.getUserByUserName(user.getUsername());
		if(existUser != null) {
			model.addAttribute("error", "Duplicate User Name, please try another one");
			return "register/register";
		}
		
		//encode password
		String encoded = encoder.encode(user.getPassword());
		user.setPassword(encoded);
		
		//set authority to user
		Role role = new Role();
		role.setAuthority("ROLE_USER");
		//role.setAuthority("ROLE_ADMIN");
		role.setUser(user);
		user.getRoles().add(role);
		
		//set enable
		user.setEnabled(true);
		
		userService.addUser(user);
		roleService.addRole(role);
		
		return "redirect:/logins";
	}
	
}
