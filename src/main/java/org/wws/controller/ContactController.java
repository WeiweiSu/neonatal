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
import org.wws.exception.AdException;
import org.wws.pojo.Contact;
import org.wws.pojo.Message;
import org.wws.service.ContactService;
import org.wws.service.MessageService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String viewContact(HttpServletRequest request, Model model) throws AdException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		List<Contact> contacts = contactService.getContactsByUserName(username);
		model.addAttribute("contacts", contacts);
		return "user/viewContact";
	}
	
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String addContact(HttpServletRequest request) throws AdException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		String contactName = request.getParameter("contactName");
		String comments = request.getParameter("comment");
		Contact contact = new Contact(username, contactName, comments, String.valueOf(new Date()));
		Contact contact1 = new Contact(contactName, username, comments, String.valueOf(new Date()));
		contactService.addContact(contact);
		contactService.addContact(contact1);
		
		
		
		
		return "user/addSuccess";
	}
	
	@RequestMapping(value="/{contactID}", method=RequestMethod.DELETE)
	public String deleteContact(@PathVariable Integer contactID) {
		contactService.removeContact(contactID);
		return "";
	}
	
	@RequestMapping(value="/{contactID}", method=RequestMethod.GET)
	public String sendMessage(@PathVariable Integer contactID, Model model) {
		Contact contact = contactService.getContact(contactID);
		String from = contact.getUsername();
		String to = contact.getContactname();
		Message message = new Message();
		message.setFromUser(from);
		message.setUsername(to);
		model.addAttribute("message", message);
		
		model.addAttribute("from", from);
		model.addAttribute("to", to);
		
		return "user/sendMessageForm";
	}
	
	
	@RequestMapping(value="/{contactID}", method=RequestMethod.POST)
	public String processSendMessage(@Valid Message message, BindingResult br, @PathVariable Integer contactID, Model model) {
		if(br.hasErrors()) {
			return "user/sendMessageForm";
		}
		
		messageService.addMessage(message);
		
		return "user/sendSuccess";
		
		
	}
	
	
//	@RequestMapping(value="delete", method=RequestMethod.POST)
//	public String deleteMessage(@RequestParam("delete") String[] deleteIDList) throws NumberFormatException, AdException {
//		for(String id : deleteIDList) {
//			contactService.removeContact(Integer.parseInt(id));
//		}
//		return "viewContact";
//	}
	
}
