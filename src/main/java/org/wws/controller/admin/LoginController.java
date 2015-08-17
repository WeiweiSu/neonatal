package org.wws.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logins")
public class LoginController {

	@RequestMapping(method=RequestMethod.GET)
	public String showLogin() {
		return "user/login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String process(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		request.getSession().setAttribute("username", username);
		return "user/homeview";
	}
	
}
