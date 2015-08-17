package org.wws.service;

import java.util.ArrayList;
import java.util.List;

import org.wws.pojo.HealthQuestion;

public interface HealthQuestionService {

	public void addHealthQuestion(HealthQuestion healthQuestion);
	public List<HealthQuestion> listHealthQuestions();
	public HealthQuestion getHealthQuestion(Integer id);
	public void removeHealthQuestion(Integer id);

	public void updateHealthQuestion(HealthQuestion healthQuestion);
	public List<HealthQuestion> listUnansweredQuestion();

	public ArrayList<HealthQuestion> listAllAnsweredQuestion();
}
