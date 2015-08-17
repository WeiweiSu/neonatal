package org.wws.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.wws.exception.AdException;
import org.wws.pojo.Contact;
import org.wws.pojo.Country;


public interface CountryDAO {
	
	public void addCountry(Country country);
	public List<Country> listCountrys();
	public Country getCountry(Integer id);
	public void removeCountry(Integer id);
	
}