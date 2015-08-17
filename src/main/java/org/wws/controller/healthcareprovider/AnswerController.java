package org.wws.controller.healthcareprovider;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wws.pojo.HealthQuestion;
import org.wws.service.HealthQuestionService;

//@Controller
//@RequestMapping("/answer")
public class AnswerController {

	//@Autowired
	private HealthQuestionService healthQuestionService;
	
	//@RequestMapping(value="/{questionID}",method=RequestMethod.GET)
	public String showPage(Model model, @PathVariable Integer questionID) {
		HealthQuestion healthquestion = healthQuestionService.getHealthQuestion(questionID);
		model.addAttribute("healthquestion", healthquestion);
		model.addAttribute("questionList", healthQuestionService.listHealthQuestions());
		
		return "healthprovider/healthprovider";
	}
	
	
	//@RequestMapping(method=RequestMethod.POST)
	public String process(@Valid @ModelAttribute("healthquestion")HealthQuestion healthquestion, BindingResult br, HttpServletRequest request, Model model) {
		if(br.hasErrors()) {
			model.addAttribute("questionList", healthQuestionService.listHealthQuestions());
			return "healthprovider/healthprovider";
		}
		
		
		healthQuestionService.updateHealthQuestion(healthquestion);
		
		return "redirect:/provider";
	}
	
}
