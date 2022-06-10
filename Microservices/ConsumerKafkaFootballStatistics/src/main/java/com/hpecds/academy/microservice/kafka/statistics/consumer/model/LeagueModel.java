package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class LeagueModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2475703638619696189L;
	private int id;
	private String name;
	private String country;
	private String logo;
	private String flag;
	private int season;

	public LeagueModel() {
		super();
	}

	public LeagueModel(int id, String name, String country, String logo, String flag, int season) {

		this.id = id;
		this.name = name;
		this.country = country;
		this.logo = logo;
		this.flag = flag;
		this.season = season;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

}
