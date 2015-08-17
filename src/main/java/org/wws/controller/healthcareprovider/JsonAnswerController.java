package org.wws.controller.healthcareprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wws.pojo.HealthQuestion;
import org.wws.service.HealthQuestionService;

@Controller
@RequestMapping("/jsonanswer")
public class JsonAnswerController {
	
	@Autowired
	private HealthQuestionService healthQuestionService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showpage() {
		return "healthprovider/jsonPage";
	}

	@RequestMapping(value="all", method=RequestMethod.GET)
	public @ResponseBody ArrayList<HealthQuestion> getAll() {
		ArrayList<HealthQuestion> json = healthQuestionService.listAllAnsweredQuestion();
		
		System.out.println(json.size());
		return json;
	}
}
