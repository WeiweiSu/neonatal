package org.wws.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wws.dao.HealthQuestionDAO;
import org.wws.pojo.HealthQuestion;

@Repository
public class HealthQuestionDaoImpl implements HealthQuestionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addHealthQuestion(HealthQuestion healthQuestion) {
		sessionFactory.getCurrentSession().save(healthQuestion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HealthQuestion> listHealthQuestions() {
		return sessionFactory.getCurrentSession().createQuery("from HealthQuestion").list();
	}

	@Override
	public HealthQuestion getHealthQuestion(Integer id) {
		return (HealthQuestion) sessionFactory.getCurrentSession().load(HealthQuestion.class, id);
	}

	@Override
	public void removeHealthQuestion(Integer id) {
		HealthQuestion healthQuestion = (HealthQuestion) sessionFactory.getCurrentSession().get(HealthQuestion.class, id);
        if (null != healthQuestion) {
        	try {
        		sessionFactory.getCurrentSession().delete(healthQuestion);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}

	@Override
	public void updateHealthQuestion(HealthQuestion healthQuestion) {
		sessionFactory.getCurrentSession().merge(healthQuestion);
		sessionFactory.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HealthQuestion> listUnansweredQuestion() {
		Query q = sessionFactory.getCurrentSession().createQuery("from HealthQuestion as hq Where (hq.answer is null)");
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<HealthQuestion> listAllAnsweredQuestion() {
		Query q = sessionFactory.getCurrentSession().createQuery("from HealthQuestion as hq Where (hq.answer is not null)");
		return (ArrayList<HealthQuestion>) q.list();
	}

}
