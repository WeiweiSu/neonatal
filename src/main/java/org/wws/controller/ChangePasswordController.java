package org.wws.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wws.exception.AdException;
import org.wws.pojo.User;
import org.wws.service.UserService;

@Controller
@RequestMapping("/password")
public class ChangePasswordController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showPage() {
		return "user/changePassword";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String requestChange(HttpServletRequest request, Model model) throws AdException {
		//HttpSession session = request.getSession();
		//String username = (String) session.getAttribute("username");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getUserByUserName(username);
		
		String oldPassword = user.getPassword();
		boolean isMatch = encoder.matches(request.getParameter("oldPassword"), oldPassword);
		String newPassword = request.getParameter("newPassword");
		if(!isMatch || !request.getParameter("newPassword").equals(request.getParameter("confirmPassword"))) {
			model.addAttribute("error", "Old password or new password with confirm one are not matched, try again.");
			return "user/changePassword";
		} else {
			
			user.setPassword(encoder.encode(newPassword));
			userService.updateUser(user);
			return "user/passwordSuccess";
		}
	}
	
}
