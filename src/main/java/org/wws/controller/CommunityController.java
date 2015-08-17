package org.wws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/community")
public class CommunityController {

	@RequestMapping(method=RequestMethod.GET)
	public String showPage() {
		return "user/community";
	}
	
}
