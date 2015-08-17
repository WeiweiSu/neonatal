//package org.wws.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.wws.service.UserService;
//
//@Controller
//@RequestMapping("/admin")
//public class Test {
//
//	@Autowired
//	private UserService userService;
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public String showHome(Model model) {
//		List userList = userService.listUsers();
//		model.addAttribute("userList", userList);
//		return "admin/home";
//	}
//}
