package org.wws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wws.exception.AdException;
import org.wws.pojo.Message;
import org.wws.service.MessageService;

@Controller
public class HomeController {


	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping("/homepage")
	public String home() {
		return "user/homeview";
	}
//	
//	@RequestMapping("/menu.htm")
//	public String menu() {
//		return "menu";
//	}
//	
//	@RequestMapping("/main.htm/{username}")
//	public String main(@PathVariable String username, Model model) throws AdException {
//		List<Message> messages = messageService.listMessagesByUserName(username);
//		int size = messages.size();
//		model.addAttribute("messages", messages);
//		model.addAttribute("size", size);
//		return "main";
//	}
}
