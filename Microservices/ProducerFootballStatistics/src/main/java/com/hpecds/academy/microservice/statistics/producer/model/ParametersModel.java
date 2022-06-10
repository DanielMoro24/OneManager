package com.hpecds.academy.microservice.statistics.producer.model;

public class ParametersModel {
	private String league;
	private String season;

	public ParametersModel() {
		super();
	}

	public ParametersModel(String league, String season) {
		this.league = league;
		this.season = season;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

}
