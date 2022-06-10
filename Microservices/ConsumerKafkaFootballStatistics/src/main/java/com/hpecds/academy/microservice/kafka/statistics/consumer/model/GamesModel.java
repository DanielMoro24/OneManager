package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class GamesModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7765267349259042425L;
	private int appearences;
	private int lineups;
	private int minutes;
	private int number;
	private String position;
	private String rating;
	private boolean captain;

	public GamesModel() {
		super();
	}

	public GamesModel(int appearences, int lineups, int minutes, int number, String position, String rating,
			boolean captain) {

		this.appearences = appearences;
		this.lineups = lineups;
		this.minutes = minutes;
		this.number = number;
		this.position = position;
		this.rating = rating;
		this.captain = captain;
	}

	public int getAppearences() {
		return appearences;
	}

	public void setAppearences(int appearences) {
		this.appearences = appearences;
	}

	public int getLineups() {
		return lineups;
	}

	public void setLineups(int lineups) {
		this.lineups = lineups;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public boolean isCaptain() {
		return captain;
	}

	public void setCaptain(boolean captain) {
		this.captain = captain;
	}

}
