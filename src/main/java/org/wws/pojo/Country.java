package org.wws.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="countryID",unique=true,nullable=false)
	private int id;

	@Column(name="countryName", unique=true, nullable=false, length=50)
	private String countryname;

	
	
	
	public Country() {
	}

	public Country(String countryname) {
		this.countryname = countryname;
	}
	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}



	

}
