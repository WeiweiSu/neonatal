package org.wws.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.wws.pdf.MyPdfView;
import org.wws.pojo.HealthQuestion;
import org.wws.service.HealthQuestionService;

@Controller
public class PdfGeneratingController {
	
	@Autowired
	private HealthQuestionService healthQuestionService;

	@RequestMapping(value = "/report.pdf", method = RequestMethod.GET)
	public ModelAndView doProcess(@RequestParam("questionID")  Integer questionID, 
			Locale locale, ModelMap model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("time", formattedDate );
		
		HealthQuestion hq = healthQuestionService.getHealthQuestion(questionID);
		model.addAttribute("question", hq);
		
		
		return new ModelAndView(new MyPdfView(), model);
	}
}
