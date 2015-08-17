package org.wws.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.wws.pojo.User;
import org.wws.service.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showform(Model model, HttpServletRequest request) {
		model.addAttribute("user", new User());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		System.out.println("current username is: " + username);
		User olduser = userService.getUserByUserName(username);
		
		model.addAttribute("olduser", olduser);
		
		return "user/profile";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult br, @RequestParam("id") Integer id) throws IllegalStateException, IOException {
		if(br.hasErrors()) {
			
			return "user/profile";
		}
		User olduser = userService.getUser(id);
		Date date = new Date();
		
		CommonsMultipartFile multiFile = user.getImage();
		if(multiFile.getSize() != 0) {
			File dest = new File("/Users/weiweisu/Documents/workspace-sts/WebFinalProject/src/main/webapp/WEB-INF/uploads/", date.toString());
            
            multiFile.transferTo(dest);
            //String url = dest.getAbsolutePath();
            String url = "uploads/" + date.toString();
            System.out.println(url);
            olduser.setUrl(url);
		}
		
		
		
		olduser.setAboutme(user.getAboutme());
		olduser.setCity(user.getCity());
		olduser.setState(user.getState());
		olduser.setCountry(user.getCountry());
		
		userService.updateUser(olduser);
		
		return "redirect:/profile/profileUpdated";
	}
	
	@RequestMapping(value="/profileUpdated", method=RequestMethod.GET)
	public String success() {
		return "user/profileUpdated";
	}
	
}
