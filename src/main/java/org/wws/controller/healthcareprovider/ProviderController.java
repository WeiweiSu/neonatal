package org.wws.controller.healthcareprovider;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wws.pojo.HealthQTransient;
import org.wws.pojo.HealthQuestion;
import org.wws.service.HealthQuestionService;

@Controller
@RequestMapping("/provider")
public class ProviderController {

	@Autowired
	private HealthQuestionService healthQuestionService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showPage(Model model) {
		model.addAttribute("healthquestionT", new HealthQTransient());
		model.addAttribute("questionList", healthQuestionService.listHealthQuestions());
		
		return "healthprovider/healthprovider";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String process(@Valid @ModelAttribute("healthquestionT")HealthQTransient healthquestionT, BindingResult br, 
			@RequestParam("id") Integer questionID,	
			HttpServletRequest request, Model model) {
		if(br.hasErrors()) {
			model.addAttribute("questionList", healthQuestionService.listHealthQuestions());
			return "healthprovider/healthprovider";
		}
		System.out.println(healthquestionT.getAnswer());
		System.out.println(questionID);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		HealthQuestion question = healthQuestionService.getHealthQuestion(questionID);
		question.setAnswer(healthquestionT.getAnswer());
		question.setAnsweredbyuser(username);
		
		
		healthQuestionService.updateHealthQuestion(question);
		
		return "redirect:/provider";
	}
	
	
	
}
