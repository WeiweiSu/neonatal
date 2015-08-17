package org.wws.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wws.dao.MessageDAO;
import org.wws.exception.AdException;
import org.wws.pojo.Message;
import org.wws.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessagesController {

	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String showMessages(Model model, HttpServletRequest request) throws AdException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		List<Message> messages = messageService.listMessagesByUserName(username);
		int size = messages.size();
		model.addAttribute("messages", messages);
		model.addAttribute("size", size);
		return "user/viewMessage";
	}
	
	@RequestMapping(value="replyfrom/{fromUser}/to/{toUser}", method=RequestMethod.GET)
	public String reply(@PathVariable String toUser,
			@PathVariable String fromUser,
			Model model) {
		model.addAttribute("toUser", toUser);
		model.addAttribute("fromUser", fromUser);
		//test
		model.addAttribute("message", new Message());
		return "user/sendMessageForm";
	}
	
	
	@RequestMapping(value="replyfrom/{fromUser}/to/{toUser}", method=RequestMethod.POST)
	public String sendMessage(@Valid Message message, BindingResult br, 
			@PathVariable String fromUser,
			@PathVariable String toUser) throws AdException {
		if(br.hasErrors()) return "user/sendMessageForm";
		
		
		message.setMessageDate(String.valueOf(new Date()));
		message.setUsername(toUser);
		message.setFromUser(fromUser);
		messageService.addMessage(message);
		//messageDao.create(toUser, fromUser, messageContent, String.valueOf(new Date()));
		return "user/sendSuccess";
	}
	
	
	
//	@RequestMapping(method=RequestMethod.POST)
//	public String sendMessage(@RequestParam("toUser") String toUser,
//			@RequestParam("fromUser") String fromUser,
//			@RequestParam("message") String messageContent) throws AdException {
//		messageDao.create(toUser, fromUser, messageContent, String.valueOf(new Date()));
//		return "sendSuccess";
//	}
	
	
	@RequestMapping(value="/{messageID}", method=RequestMethod.DELETE)
	public String deleteMessage(@PathVariable Integer messageID) throws AdException {
			messageService.removeMessage(messageID);
		
		return "";
	}
	
}
