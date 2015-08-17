package org.wws.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wws.dao.CountryDAO;
import org.wws.pojo.Country;
import org.wws.service.CountryService;
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDAO countryDAO;
	
	@Override
	public void addCountry(Country country) {
		countryDAO.addCountry(country);
	}

	@Override
	public List<Country> listCountrys() {
		return countryDAO.listCountrys();
	}

	@Override
	public Country getCountry(Integer id) {
		return countryDAO.getCountry(id);
	}

	@Override
	public void removeCountry(Integer id) {
		countryDAO.removeCountry(id);
	}

}
