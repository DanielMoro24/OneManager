package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class GoalsModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3191514350921582467L;
	private int total;
	private int conceded;
	private int assists;
	private int saves;

	public GoalsModel() {
		super();
	}

	public GoalsModel(int total, int conceded, int assists, int saves) {

		this.total = total;
		this.conceded = conceded;
		this.assists = assists;
		this.saves = saves;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getConceded() {
		return conceded;
	}

	public void setConceded(int conceded) {
		this.conceded = conceded;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getSaves() {
		return saves;
	}

	public void setSaves(int saves) {
		this.saves = saves;
	}

}
