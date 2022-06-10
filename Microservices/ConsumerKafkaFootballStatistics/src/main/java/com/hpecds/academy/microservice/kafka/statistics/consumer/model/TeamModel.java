package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class TeamModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5175041618362225050L;
	private int id;
	private String name;
	private String logo;

	public TeamModel() {
		super();
	}

	public TeamModel(int id, String name, String logo) {

		this.id = id;
		this.name = name;
		this.logo = logo;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
