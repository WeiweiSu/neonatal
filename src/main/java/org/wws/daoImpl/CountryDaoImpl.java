package org.wws.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wws.dao.CountryDAO;
import org.wws.pojo.Country;

@Repository
public class CountryDaoImpl implements CountryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addCountry(Country country) {
		sessionFactory.getCurrentSession().save(country);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> listCountrys() {
		return sessionFactory.getCurrentSession().createQuery("from Country").list();
	}

	@Override
	public Country getCountry(Integer id) {
		return (Country) sessionFactory.getCurrentSession().get(Country.class, id);
	}

	@Override
	public void removeCountry(Integer id) {
		Country country = (Country) sessionFactory.getCurrentSession().get(Country.class, id);
        if (null != country) {
        	try {
        		sessionFactory.getCurrentSession().delete(country);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}

}
