//package org.wws.controller;
//
//import java.util.List;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.wws.exception.AdException;
//import org.wws.pojo.Message;
//import org.wws.pojo.User;
//import org.wws.service.MessageService;
//import org.wws.service.UserService;
//
////@Controller
////@RequestMapping("/login.htm")
//public class LoginController {
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private MessageService messageService;
//
//	private String remember = "unchecked";
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String login(HttpServletRequest request,
//			HttpServletResponse response, Model model) throws AdException {
//		String userName = null;
//		
//		Cookie[] cookies = request.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("user")) {
//					userName = cookie.getValue();
//				}
//			}
//		}
//		if (userName == null) {
//			return "login";
//		} else {
//			HttpSession session = request.getSession();
//			session.setAttribute("username", userName);
//			return "home";
//		}
//
//	}
//
//	@RequestMapping(method = RequestMethod.POST)
//	public String loginProcess(
//			@RequestParam("userName") String userName,
//			@RequestParam("password") String password,
//			Model model,
//			HttpServletRequest request, 
//			HttpServletResponse response)
//			throws AdException {
//		remember = request.getParameter("remember");
//		User user = userService.getUser(userName, password);
//		if (user != null) {
//			List<Message> messages = messageService.listMessagesByUserName(userName);
//			int size = messages.size();
//				if (("checked").equals(remember)) {
//						loginCookie(response, userName);
//					}
//				HttpSession session = request.getSession();
//				session.setAttribute("username", userName);
//				// getMessages(userName, model);
//				model.addAttribute("messages", messages);
//				model.addAttribute("size", size);
//				return "home";
//		} else {
//			model.addAttribute("error",
//					"user name or password is incorrect, please try again.");
//			return "login";
//		}
//
//	}
//
//	private void loginCookie(HttpServletResponse response, String userName) {
//		Cookie loginCookie = new Cookie("user", userName);
//		loginCookie.setMaxAge(30 * 60);
//		response.addCookie(loginCookie);
//	}
//
//	private void getMessages(String username, Model model) throws AdException {
//		List<Message> messages = messageService.listMessagesByUserName(username);
//		int size = messages.size();
//		model.addAttribute("messages", messages);
//		model.addAttribute("size", size);
//	}
//
//}
