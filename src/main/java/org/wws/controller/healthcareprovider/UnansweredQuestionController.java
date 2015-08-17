package org.wws.controller.healthcareprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wws.pojo.HealthQTransient;
import org.wws.service.HealthQuestionService;

@Controller
@RequestMapping("/unanswered")
public class UnansweredQuestionController {

	@Autowired
	private HealthQuestionService healthQuestionService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showpage(Model model) {
		List unanswered = healthQuestionService.listUnansweredQuestion();
		model.addAttribute("healthquestionT", new HealthQTransient());
		model.addAttribute("unanswered", unanswered);
		
		return "healthprovider/unanswered";
	}
}
