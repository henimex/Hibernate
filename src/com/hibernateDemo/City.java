package com.hibernateDemo;

import javax.persistence.*;

@Entity
@Table(name="city")

public class City {
	@Id
	@Column
	private int id;
	private String nameString;
	private String countryCodeString;
	private String districtString;
	private int population;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getCountryCodeString() {
		return countryCodeString;
	}

	public void setCountryCodeString(String countryCodeString) {
		this.countryCodeString = countryCodeString;
	}

	public String getDistrictString() {
		return districtString;
	}

	public void setDistrictString(String districtString) {
		this.districtString = districtString;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
}
