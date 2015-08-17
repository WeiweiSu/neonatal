package org.wws.dao;

import java.util.ArrayList;
import java.util.List;

import org.wws.pojo.HealthQuestion;

public interface HealthQuestionDAO {
	public void addHealthQuestion(HealthQuestion healthQuestion);
	public List<HealthQuestion> listHealthQuestions();
	public HealthQuestion getHealthQuestion(Integer id);
	public void removeHealthQuestion(Integer id);
	
	public void updateHealthQuestion(HealthQuestion healthQuestion);
	
	public List<HealthQuestion> listUnansweredQuestion();
	
	public ArrayList<HealthQuestion> listAllAnsweredQuestion();
}
