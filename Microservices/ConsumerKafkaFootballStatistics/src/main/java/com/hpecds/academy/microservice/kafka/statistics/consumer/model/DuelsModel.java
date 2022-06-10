package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class DuelsModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7102767625356805306L;
	private int total;
	private int won;

	public DuelsModel() {
		super();
	}

	public DuelsModel(int total, int won) {

		this.total = total;
		this.won = won;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

}
