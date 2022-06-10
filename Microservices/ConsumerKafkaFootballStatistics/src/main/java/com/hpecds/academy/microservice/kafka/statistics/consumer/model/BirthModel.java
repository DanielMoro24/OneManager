package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class BirthModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2632615520437983905L;
	private String date;
	private String place;
	private String country;

	public BirthModel() {
		super();
	}

	public BirthModel(String date, String place, String country) {
		this.date = date;
		this.place = place;
		this.country = country;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
