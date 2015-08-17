package org.wws.accessdeniedhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/403")
public class AccessDeniedController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String shwopage() {
		return "403";
	}
}
