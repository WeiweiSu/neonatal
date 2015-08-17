package org.wws.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/deletesuccess")
public class DeleteSuccessController {

	@RequestMapping(method=RequestMethod.GET)
	public String showpage() {
		return "admin/deleteSuccess";
	}
}
