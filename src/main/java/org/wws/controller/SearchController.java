package org.wws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wws.dao.UserDAO;
import org.wws.exception.AdException;
import org.wws.pojo.User;
import org.wws.service.UserService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String searchPage() {
		return "user/search";
	}
	
	
	@RequestMapping(value="lookUpByMemberNum", method=RequestMethod.POST)
	public String lookUpByMemberNum(@RequestParam("memberNum") Integer id, Model model) throws NumberFormatException, AdException {
		if("".equals(id) || id == null) {
			model.addAttribute("error", "No search result, please try another member number");
			return "redirect:/search";
		}
		
		User user = userService.getUser(id);
		if(user == null) {
			model.addAttribute("error", "No search result, please try another member number");
			return "redirect:/search";
		} else {
			List<User> users = new ArrayList();
			users.add(user);
			model.addAttribute("users", users);
			return "user/searchSuccess";
		}
	}
	
	
	@RequestMapping(value="lookUpByUsername", method=RequestMethod.POST)
	public String lookUpByUsername(@RequestParam("username") String username, Model model) throws NumberFormatException, AdException {
		User user = userService.getUserByUserName(username);
		if(user == null) {
			model.addAttribute("error", "No search result, please try another member number");
			return "redirect:/search";
		} else {
			List<User> users = new ArrayList();
			users.add(user);
			model.addAttribute("users", users);
			return "user/searchSuccess";
		}
	}
	
	@RequestMapping(value="{contactName}")
	public String showContactForm(@PathVariable String contactName, Model model) {
		model.addAttribute("userToAdd", contactName);
		return "user/addToContact";
	}
	
}
