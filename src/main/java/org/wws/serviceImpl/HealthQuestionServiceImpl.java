package org.wws.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wws.dao.HealthQuestionDAO;
import org.wws.pojo.HealthQuestion;
import org.wws.service.HealthQuestionService;

@Service
public class HealthQuestionServiceImpl implements HealthQuestionService {

	@Autowired
	private HealthQuestionDAO healthQuestionDAO;
	
	@Override
	public void addHealthQuestion(HealthQuestion healthQuestion) {
		healthQuestionDAO.addHealthQuestion(healthQuestion);
	}

	@Override
	public List<HealthQuestion> listHealthQuestions() {
		return healthQuestionDAO.listHealthQuestions();
	}

	@Override
	public HealthQuestion getHealthQuestion(Integer id) {
		return healthQuestionDAO.getHealthQuestion(id);
	}

	@Override
	public void removeHealthQuestion(Integer id) {
		healthQuestionDAO.removeHealthQuestion(id);
	}

	@Override
	public void updateHealthQuestion(HealthQuestion healthQuestion) {
		healthQuestionDAO.updateHealthQuestion(healthQuestion);
	}

	@Override
	public List<HealthQuestion> listUnansweredQuestion() {
		return healthQuestionDAO.listUnansweredQuestion();
	}

	@Override
	public ArrayList<HealthQuestion> listAllAnsweredQuestion() {
		return healthQuestionDAO.listAllAnsweredQuestion();
	}

}
