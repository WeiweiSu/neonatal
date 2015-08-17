package org.wws.controller.admin;

import java.util.List;

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
import org.wws.service.RoleService;
import org.wws.service.UserService;

@Controller
@RequestMapping("/providerAccounts")
public class ProviderAccountController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showform(Model model) {
		model.addAttribute("user", new User());
		
		List<User> providers = userService.listUsersByRole("ROLE_PROVIDER");
		model.addAttribute("userList", providers);
		return "admin/providers";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String assignUA(@Valid User user, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "admin/providers";
		}
		
		//check if username is existed
		User existUser = userService.getUserByUserName(user.getUsername());
		if(existUser != null) {
			model.addAttribute("error", "Duplicate User Name, please try another one");
			return "admin/providers";
		}
		
		
		
		//encode password
		String encoded = encoder.encode(user.getPassword());
		user.setPassword(encoded);
		
		user.setEnabled(true);
		
		Role role = new Role();
		role.setAuthority("ROLE_PROVIDER");
		role.setUser(user);
		user.getRoles().add(role);
		
		userService.addUser(user);
		roleService.addRole(role);
		
		return "redirect:/providerAccounts";
		
	}
	
	@RequestMapping(value="/{userID}", method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer userID, Model model) {
		userService.removeUser(userID);
		model.addAttribute("deleteinfo", "Delete Successfully");
		
		return "";
	}
	
}
