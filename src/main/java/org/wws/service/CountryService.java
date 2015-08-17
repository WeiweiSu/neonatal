package org.wws.service;

import java.util.List;

import org.wws.pojo.Country;

public interface CountryService {
	public void addCountry(Country country);
	public List<Country> listCountrys();
	public Country getCountry(Integer id);
	public void removeCountry(Integer id);
	
}
