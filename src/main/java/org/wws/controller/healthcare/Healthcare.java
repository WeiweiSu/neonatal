package org.wws.controller.healthcare;

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

@Controller
@RequestMapping("/healthcare*")
public class Healthcare {

	@Autowired
	private HealthQuestionService healthQuestionService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showPage(Model model) {
		model.addAttribute("healthquestion", new HealthQuestion());
		model.addAttribute("questionList", healthQuestionService.listHealthQuestions());
		
		return "user/healthcare";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String process(@Valid @ModelAttribute("healthquestion")HealthQuestion healthquestion, BindingResult br, HttpServletRequest request, Model model) {
		if(br.hasErrors()) {
			model.addAttribute("questionList", healthQuestionService.listHealthQuestions());
			return "user/healthcare";
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		healthquestion.setFromuser(username);
		
		healthQuestionService.addHealthQuestion(healthquestion);
		
		return "redirect:/healthcare";
	}
	
	@RequestMapping(value="/{questionID}", method=RequestMethod.GET)
	public String seeDetail(@PathVariable Integer questionID, Model model) {
		HealthQuestion question = healthQuestionService.getHealthQuestion(questionID);
		model.addAttribute("question", question);
		
		return "user/questiondetail";
	}
	
	
}
